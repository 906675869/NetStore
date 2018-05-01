package com.bdsoft.xtgl.mapper;

import com.bdsoft.xtgl.entity.Login;
import com.bdsoft.xtgl.entity.User;

import java.util.List;
public interface UserMapper {
    List<User> getAll();

    User getOne(Integer id);

    int insert(User user);

    void update(User user);

    void delete(Integer id);

    User selectUserByLoginName(Login login);
}
