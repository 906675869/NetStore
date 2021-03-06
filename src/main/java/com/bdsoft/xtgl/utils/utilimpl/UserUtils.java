package com.bdsoft.xtgl.utils.utilimpl;

import com.bdsoft.xtgl.entity.Function;
import com.bdsoft.xtgl.entity.Role;
import com.bdsoft.xtgl.service.UserServiceI;
import com.bdsoft.xtgl.utils.UserUtilsI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * 登录用户信息查询
 */
@Component
public class UserUtils implements UserUtilsI {
    //注入UserService
    @Autowired
    private UserServiceI userServiceI;

    public UserServiceI getUserServiceI() {
        return userServiceI;
    }

    public void setUserServiceI(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    @Override
    public String getUserNameById(Integer id) {
        return userServiceI.getOne(id).getName();
    }

    @Override
    public Integer getCurrentUserId() {
        return userServiceI.getCurrentUser().getId();
    }

    @Override
    public String getCurrentUserName() {
        if( StringUtils.isEmpty(userServiceI.getCurrentUser())){ return ""; }
        return userServiceI.getCurrentUser().getName();
    }

    @Override
    public List<Role> getCurrentUserRoles() {
        return userServiceI.getUserRoles(userServiceI.getCurrentUser());
    }

    @Override
    public List<Function> getCurrentUserFunctions() {
        return userServiceI.getUserFunctions(userServiceI.getCurrentUser());
    }
}
