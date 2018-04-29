package com.example.demo.util;

import com.example.demo.entity.Function;
import com.example.demo.entity.Role;

import java.util.List;

public interface UserUtilsI {
    /**
     * 通过用户id获取用户名称
     */
     String getUserNameById(Integer id);
    /**
     * 获取当前用户的id
     * @return
     */
    Integer getCurrentUserId();
    /**
     * 获取当前用户的用户名
     */
     String getCurrentUserName();
    /**
     * 获取当前用户的所有角色
     * @return
     */
    List<Role> getCurrentUserRoles();
    /**
     * 获取当前用户所有权限、URL
     * @return
     */
    List<Function>  getCurrentUserFunctions();
}
