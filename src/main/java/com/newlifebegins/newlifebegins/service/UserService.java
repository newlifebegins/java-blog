package com.newlifebegins.newlifebegins.service;

import com.newlifebegins.newlifebegins.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 用户服务接口
 * @auth wangwei
 * @time 2019/12/9
 */
public interface UserService {
    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    User saveUser(User user);
    /**
     * 删除用户
     * @param user
     * @return
     */
    void removeUser(Long id);

    /**
     * 删除列表里面的用户
     * @param user
     * @return
     */
    void removeUsersInBatch(List<User> users);

    /**
     * 更新用户
     * @param user
     * @return
     */
    User updateUser(User user);

    /**
     * 根据id获取用户
     * @param user
     * @return
     */
    User getUserById(Long id);

    /**
     * 获取用户列表
     * @param user
     * @return
     */
    List<User> listUsers();

    /**
     * 根据用户名进行分页模糊查询
     * @param user
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);

    User findByUsername(String username);
}
