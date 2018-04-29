package com.bdsoft.xtgl.mapper;

import com.bdsoft.xtgl.entity.Function;
import com.bdsoft.xtgl.entity.Role;
import com.bdsoft.xtgl.entity.User;

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
