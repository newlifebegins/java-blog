package com.newlifebegins.newlifebegins.config;

import com.newlifebegins.newlifebegins.repository.UserRepository;
import com.newlifebegins.newlifebegins.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 安全配置类
 * @auth wangwei
 * @time 2019/12/7
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用方法安全设置
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String KEY = "newlifebegins";

    @Bean
    public BCryptPasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // 设置密码加密方式
        return authenticationProvider;
    }
    /**
     * 自定义配置
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()  // 都可以访问
                .antMatchers("/h2-console/**").permitAll()  // 都可以访问
                .antMatchers("/admins/**").hasRole("ADMIN")  // 需要相应的角色才可以访问
                .and()
                .formLogin()  // 基于form表单登录验证
                .loginPage("/login").failureUrl("/login-error")  // 自定义登录界面
                .and().rememberMe().key(KEY)  // 启用remember me
                .and().exceptionHandling().accessDeniedPage("/403");  // 处理异常，拒绝访问就重定向到403
        http.csrf().ignoringAntMatchers("/h2-console/**");  // 禁用H2控制台的csrf防护
        http.headers().frameOptions().sameOrigin();  // 允许来自同一来源的H2控制台的请求
    }
    /**
     * 认证信息管理
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
        auth.authenticationProvider(authenticationProvider());
    }

    // 用户登录实现
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Autowired
            private UserRepository userRepository;
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepository.findByUsername(username);
                if(user == null) throw new UsernameNotFoundException("Username " + username + " not found");
                return user;
            }
        };
    }
}
