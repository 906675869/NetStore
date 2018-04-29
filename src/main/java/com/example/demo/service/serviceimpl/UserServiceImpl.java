package com.example.demo.service.serviceimpl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserServiceI;
import com.example.demo.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private UserMapper userMapper;

    public RedisUtils getRedisUtils() {
        return redisUtils;
    }

    public void setRedisUtils(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> getAll() {
        boolean b = redisUtils.exists("User");
        List<User> list;
       if(!b){
            list = userMapper.getAll();
            redisUtils.set("User",list);
        }
        return  (List<User>)redisUtils.get("User");
    }

    @Override
    public User getOne(Integer id) {
        String key = "User:"+id;
        boolean b = redisUtils.exists(key);
        User user;
        if(!b){
            user = userMapper.getOne(id);
            redisUtils.set(key,user);
        }
        return (User)redisUtils.get("key");
    }

    @Override
    public void insert(User user) {
        String key = "User:"+user.getId();
        redisUtils.set(key,user);
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        String key = "User:"+user.getId();
        redisUtils.set(key,user);
        userMapper.update(user);
    }

    @Override
    public void delete(Integer id) {
        String key = "User:"+id;
        redisUtils.remove(key);
        userMapper.delete(id);
    }
}
