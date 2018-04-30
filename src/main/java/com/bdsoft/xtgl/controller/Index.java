package com.bdsoft.xtgl.controller;

import com.bdsoft.xtgl.service.LoginServiceI;
import com.bdsoft.xtgl.service.UserServiceI;
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

    @RequestMapping("/index")
    public String index(){
        return "index";
//        List<User> list =  userServiceI.getAll();
//        return list.toString();
//        return "hello";
    }
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("userName")String userName,@RequestParam("password")String password){
        return loginServiceI.doLogin(userName,password);
    }

}
