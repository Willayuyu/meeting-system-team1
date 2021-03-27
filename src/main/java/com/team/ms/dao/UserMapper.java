package com.team.ms.dao;

import com.team.ms.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper
{
    void insertUser(User user);
    void updateUser(User user);
    List<User> selectUsers();
    User selectUserById(String uid);
    void deleteUser(String uid);
    boolean isUsernameExist(String username);
    boolean isEmailExist(String email);
    boolean isPhoneExist(String phone);
}
