package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class Index {
    @Autowired
    private UserServiceI userServiceI;
    @ResponseBody
    @RequestMapping("/index")
    public String index(){
        List<User> list =  userServiceI.getAll();
        return list.toString();
//        return "hello";
    }
}
