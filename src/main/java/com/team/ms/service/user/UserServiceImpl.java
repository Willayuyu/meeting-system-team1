package com.team.ms.service.user;

import com.team.ms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserService userService;
    @Override
    public List<User> selectUsersByForum(String forumname) {
        return userService.selectUsersByForum(forumname);
    }
}
