package com.bdsoft.xtgl.service.serviceimpl;

import com.bdsoft.xtgl.mapper.FunctionMapper;
import com.bdsoft.xtgl.mapper.RoleMapper;
import com.bdsoft.xtgl.util.utilimpl.RedisUtils;
import com.bdsoft.xtgl.entity.Function;
import com.bdsoft.xtgl.entity.Role;
import com.bdsoft.xtgl.entity.User;
import com.bdsoft.xtgl.mapper.UserMapper;
import com.bdsoft.xtgl.service.UserServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private FunctionMapper functionMapper;
    @Autowired
    private RoleMapper roleMapper;

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

    public FunctionMapper getFunctionMapper() {
        return functionMapper;
    }

    public void setFunctionMapper(FunctionMapper functionMapper) {
        this.functionMapper = functionMapper;
    }

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }

    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
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

    @Override
    public User getCurrentUser() {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求
        HttpServletRequest request = attributes.getRequest();
        Object object  = request.getSession().getAttribute(USERSESSION);
        if(!StringUtils.isEmpty(object)){
            User user = (User)object;
            return user;
        }
        return null;
    }

    @Override
    public List<Role> getUserRoles(User user) {
        return roleMapper.getRolesByUser(user);
    }

    @Override
    public List<Function> getUserFunctions(User user) {
        return functionMapper.getFunctionsByUser(user);
    }

    @Override
    public List<Function> getCurrentUserFunctions() {
        return getUserFunctions(getCurrentUser());
    }
}
