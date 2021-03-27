package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.pojo.Admin;
import com.team.ms.pojo.Result;
import com.team.ms.pojo.ResultCode;
import com.team.ms.service.admin.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AdminController {
  @Autowired
  AdminService adminService;

  @RequestMapping("/insertAdmin")
  public String insertAdmin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("realname") String realname
  ){
    Admin admin = new Admin(username, password, realname, Admin.FORUM_CHAIRMAN);
    try {
      adminService.insertAdmin(admin);
      return JSON.toJSONString(Result.successResult());
    } catch (Exception e) {
      return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
    }
  }
}

