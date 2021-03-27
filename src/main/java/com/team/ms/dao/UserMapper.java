package com.team.ms.dao;

import com.team.ms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper
{
    void insertUser(User user);
    void updateUserByObject(User user);
    void updateUserByMap(Map params);
    List<User> selectUsersByMap(Map params);
    User selectUserById(String uid);
    List<User> selectUsersByForum(String forumname);
    void deleteUser(String uid);
    boolean isUsernameExist(String username);
    boolean isEmailExist(String email);
    boolean isPhoneExist(String phone);
    int getTotalParticipants();
}
