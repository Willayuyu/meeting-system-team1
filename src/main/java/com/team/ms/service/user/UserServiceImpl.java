package com.team.ms.service.user;

import com.team.ms.dao.UserMapper;
import com.team.ms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> selectUsersByForum(String formname) {
        return userMapper.selectUsersByForum(formname);
    }
}
