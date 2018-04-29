package com.example.demo.service;

import com.example.demo.entity.Function;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;

import java.util.List;

public interface UserServiceI {
    final String USERSESSION = "USERSESSION";
    /**
     * 获取所有的列 、行
     * @return
     */
     List<User> getAll();

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    User getOne(Integer id);

    /**
     * 插入user对象
     * @param user
     */
    void insert(User user);

    /**
     * 更新user对象
     * @param user
     */
    void update(User user);

    /**
     * 删除user对象
     * @param id
     */
    void delete(Integer id);
    /**
     * 获取当前用户的信息
     */
    User getCurrentUser();
    /**
     * 获取用户角色
     */
    List<Role> getUserRoles(User user);
    /**
     * 获取用户权限
     */
    List<Function> getUserFunctions(User user);

}
