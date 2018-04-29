package com.bdsoft.xtgl.controller;

import com.bdsoft.xtgl.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Index {
    @Autowired
    private UserServiceI userServiceI;



    public UserServiceI getUserServiceI() {
        return userServiceI;
    }

    public void setUserServiceI(UserServiceI userServiceI) {
        this.userServiceI = userServiceI;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
//        List<User> list =  userServiceI.getAll();
//        return list.toString();
//        return "hello";
    }
    @RequestMapping("/login")
    public String login(){
        return null;
    }

}
