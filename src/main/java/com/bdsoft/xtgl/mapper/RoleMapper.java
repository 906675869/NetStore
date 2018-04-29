package com.bdsoft.xtgl.mapper;

import com.bdsoft.xtgl.entity.Role;
import com.bdsoft.xtgl.entity.User;

import java.util.List;

public interface RoleMapper {
    List<Role> getAll();

    Role getOne(Integer id);

    void insert(Role role);

    void update(Role role);

    void delete(Integer id);

    List<Role> getRolesByUser(User user);
}
