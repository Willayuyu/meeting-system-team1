package com.team.ms.service.user;

import com.team.ms.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectUsersByForum();
}
