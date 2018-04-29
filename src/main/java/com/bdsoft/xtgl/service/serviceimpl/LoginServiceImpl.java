package com.bdsoft.xtgl.service.serviceimpl;

import com.bdsoft.xtgl.entity.Login;
import com.bdsoft.xtgl.entity.User;
import com.bdsoft.xtgl.mapper.LoginMapper;
import com.bdsoft.xtgl.service.LoginServiceI;
import com.bdsoft.xtgl.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
public class LoginServiceImpl implements LoginServiceI {
    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private UserServiceI userServiceI;

    public UserServiceI getUserServiceI() {
        return userServiceI;
    }

    public void setUserServiceI(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    public LoginMapper getLoginMapper() {
        return loginMapper;
    }

    public void setLoginMapper(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    @Override
    public String doLogin(String loginName, String password) {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求
        HttpServletRequest request = attributes.getRequest();
        Login login = loginMapper.selectByLoginName(loginName);
        if(StringUtils.isEmpty(login)){
            return "用户不存在";
        }
        if(! password.equals(login.getLoginname())){
            return "密码不正确";
        }
        User user = userServiceI.getUserByLoginName(login);
        request.getSession().setAttribute(UserServiceI.USERSESSION,user);

        return "登录成功";
    }
}
