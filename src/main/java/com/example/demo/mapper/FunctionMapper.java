package com.example.demo.mapper;

import com.example.demo.entity.Function;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;

import java.util.List;

public interface FunctionMapper {
    List<Function> getAll();

    List<Function> getFunctionsByRole(Role role);

    List<Function> getFunctionsByUser(User user);

    Function getOne(Integer id);

    void insert(Function function);

    void update(Function function);

    void delete(Integer id);


}
