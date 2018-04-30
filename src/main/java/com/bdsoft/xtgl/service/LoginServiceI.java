package com.bdsoft.xtgl.service;

import com.bdsoft.xtgl.entity.Login;

public interface LoginServiceI {
    public String doLogin(String loginName,String password);
    public boolean updateLogin(Login login);
}
