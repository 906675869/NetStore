package com.bdsoft.xtgl.service;

import com.bdsoft.xtgl.entity.Function;
import com.bdsoft.xtgl.entity.Login;
import com.bdsoft.xtgl.entity.Role;
import com.bdsoft.xtgl.entity.User;

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

    /**
     * 获取当前用户权限
     */
    List<Function> getCurrentUserFunctions();

    /**
     * 通过登录名获取当前用户
     * @param login 登录信息
     * @return 用户信息
     */
    User getUserByLoginName(Login login);

    /*清除登录用户的session 登出操作*/
    boolean clearUserSession();
}
