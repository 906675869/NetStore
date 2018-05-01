package com.bdsoft.xtgl.controller;

import com.bdsoft.xtgl.entity.Register;
import com.bdsoft.xtgl.service.LoginServiceI;
import com.bdsoft.xtgl.service.UserServiceI;
import com.bdsoft.xtgl.util.utilimpl.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Index {
    @Autowired
    private UserServiceI userServiceI;
    @Autowired
    private LoginServiceI loginServiceI;
    @Autowired
    private UserUtils userUtils;

    public UserUtils getUserUtils() {
        return userUtils;
    }

    public void setUserUtils(UserUtils userUtils) {
        this.userUtils = userUtils;
    }

    public UserServiceI getUserServiceI() {
        return userServiceI;
    }

    public void setUserServiceI(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    public LoginServiceI getLoginServiceI() {
        return loginServiceI;
    }

    public void setLoginServiceI(LoginServiceI loginServiceI) {
        this.loginServiceI = loginServiceI;
    }
    //系统首页
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
   //用户登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("userName")String userName,@RequestParam("password")String password){
        return loginServiceI.doLogin(userName,password);
    }
//    获取登录用户名字
    @ResponseBody
    @RequestMapping("/getLoginName")
    public String getLoginName(){
        return userUtils.getCurrentUserName();
    }
// 清除session存储
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(){
        return String.valueOf(userServiceI.clearUserSession());
    }
    //注册用户
    @ResponseBody
    @RequestMapping("/register")
    public String register(Register register){
        return userServiceI.register(register);
    }


}
