package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller
public interface UserServiceI {
    /**
     * 获取所有的列 、行
     * @return
     */
    public List<User> getAll();

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
}
