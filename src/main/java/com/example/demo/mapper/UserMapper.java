package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;
public interface UserMapper {
    List<User> getAll();

    User getOne(Integer id);

    void insert(User user);

    void update(User user);

    void delete(Integer id);
}
