package com.newlifebegins.newlifebegins.repository;

import com.newlifebegins.newlifebegins.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository 接口
 * @auth wangwei
 * @time 2019/12/4
 */
public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * 根据用户姓名分页查询用户列表
     * @param name
     * @param pageable
     * @return
     */
    Page<User> findByNameLike(String name, Pageable pageable);

    /**
     * 根据用户账号查询用户列表
     * @param username
     * @return
     */
    User findByUsername(String username);

}
