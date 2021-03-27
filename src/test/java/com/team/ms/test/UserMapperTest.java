package com.team.ms.test;

import com.team.ms.dao.UserMapper;
import com.team.ms.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void insertUserTest(){
        //测试正常数据
        User user = new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setRealname("realname");
        user.setUid("id");
        user.setEmail("123@123.com");
        user.setPhone("123456");
        userMapper.insertUser(user);
        //测试Uid为空的数据
        user.setUsername("1");
        user.setPassword("1");
        user.setRealname("1");
        user.setUid("");
        user.setEmail("1");
        user.setPhone("1");
        userMapper.insertUser(user);
        //测试只有Uid的数据
        user.setUsername("");
        user.setPassword("");
        user.setRealname("");
        user.setUid("1");
        user.setEmail("");
        user.setPhone("");
        userMapper.insertUser(user);
    }

    @Test
    public void updateUserByObjectTest(){
        //测试正常数据
        User user = new User();
        user.setUsername("username1");
        user.setPassword("password1");
        user.setRealname("realname1");
        user.setUid("id");
        user.setEmail("123@123.com1");
        user.setPhone("1234561");
        userMapper.updateUserByObject(user);
        //测试空数据
        user.setUsername("");
        user.setPassword("");
        user.setRealname("");
        user.setUid("id");
        user.setEmail("");
        user.setPhone("");
        userMapper.updateUserByObject(user);
    }

    @Test
    public void updateUserByMapTest(){
        //测试正常数据
        Map<String,String> map = new HashMap<>();
        map.put("username","username");
        map.put("email","email@123.com");
        map.put("phone","12345678901");
        map.put("realname","realname");
        map.put("password","qwe123");
        userMapper.updateUserByMap(map);
        //测试异常数据
        map = new HashMap<>();
        map.put("username","");
        map.put("email","");
        map.put("phone","");
        map.put("realname","");
        map.put("password","");
        userMapper.updateUserByMap(map);
    }

    @Test
    public void selectUsersByMapTest(){
        //测试正常数据
        Map<String,String> map = new HashMap<>();
        map.put("username","username");
        userMapper.selectUsersByMap(map);
        map.put("email","email@123.com");
        userMapper.selectUsersByMap(map);
        map.put("phone","12345678901");
        userMapper.selectUsersByMap(map);
        map.put("realname","realname");
        userMapper.selectUsersByMap(map);
        map.put("password","qwe123");
        userMapper.selectUsersByMap(map);
        //测试异常数据
        map = new HashMap<>();
        map.put("username","");
        userMapper.selectUsersByMap(map);
        map.put("email","");
        userMapper.selectUsersByMap(map);
        map.put("phone","");
        userMapper.selectUsersByMap(map);
        map.put("realname","");
        userMapper.selectUsersByMap(map);
        map.put("password","");
        userMapper.selectUsersByMap(map);
    }

    @Test
    public void selectUserByIdTest(){
        //测试查询正常数据
        User user = userMapper.selectUserById("id");
        System.out.println(user.getUsername() + user.getRealname());
        //测试查询空数据
        user = userMapper.selectUserById("");
        System.out.println(user.getUsername() + user.getRealname());
    }

    @Test
    public void deleteUserTest(){
        //测试删除正常数据
        String UID = "id";
        userMapper.deleteUser(UID);
        //测试删除空数据
        UID = "";
        userMapper.deleteUser(UID);
    }

    @Test
    public void isUsernameExistTest(){
        //测试正常数据
        String username = "username";
        System.out.println(userMapper.isUsernameExist(username));
        //测试空数据
        username = "";
        System.out.println(userMapper.isUsernameExist(username));
        //测试随机数据
        username = "wqe213";
        System.out.println(userMapper.isUsernameExist(username));
    }

    @Test
    public void isEmailExistTest(){
        //测试正常数据
        String email = "email@123.com";
        System.out.println(userMapper.isEmailExist(email));
        //测试空数据
        email = "";
        System.out.println(userMapper.isEmailExist(email));
        //测试随机数据
        email = "wqe213";
        System.out.println(userMapper.isEmailExist(email));
    }

    @Test
    public void isPhoneExistTest(){
        //测试正常数据
        String phone = "12345678910";
        System.out.println(userMapper.isPhoneExist(phone));
        //测试空数据
        phone = "";
        System.out.println(userMapper.isPhoneExist(phone));
        //测试随机数据
        phone = "wqe213";
        System.out.println(userMapper.isPhoneExist(phone));
    }
}
