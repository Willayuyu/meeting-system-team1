package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.pojo.Result;
import com.team.ms.pojo.User;
import com.team.ms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    UserService userService;
    
    @RequestMapping("/selectUsersByForum")
    public String selectUsersByForum(@RequestParam("formname") String formname){
        List<User> users = userService.selectUsersByForum(formname);
        return JSON.toJSONString(Result.successResult(users));
    }

}
