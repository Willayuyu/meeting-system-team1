package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.team.ms.dao.FUMapper;
import com.team.ms.pojo.Admin;
import com.team.ms.pojo.Result;
import com.team.ms.pojo.ResultCode;
import com.team.ms.pojo.User;
import com.team.ms.service.login.LoginService;
import com.team.ms.service.register.RegisterService;
import com.team.ms.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class AccountController
{
  @Autowired
  private LoginService loginService;

  @Autowired
  private RegisterService registerService;

  @Autowired
  private FUMapper fuMapper;

  @PostMapping("/login")
  public String login(@RequestParam("username") String username,
                      @RequestParam("password") String password,
                      @RequestParam("type") int type)
  {
    if(type==1)
    {
      int status=loginService.judgeUserToken(username,password);
      if(status==LoginService.CORRECT)
      {
        User user=loginService.getUserByLoginName(username);
        return JSON.toJSONString(Result.successResult(user));
      }
      else if(status==LoginService.USERNAME_WRONG)
      {
        return JSON.toJSONString(Result.failureResult(ResultCode.USERNAME_WRONG));
      }
      else if(status==LoginService.PASSWORD_WRONG)
      {
        return JSON.toJSONString(Result.failureResult(ResultCode.PASSWORD_WRONG));
      }
      return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
    }
    else
    {
      int status=loginService.judgeAdminToken(username,password);
      if(status==LoginService.CORRECT)
      {
        Admin admin=loginService.getAdminByLoginName(username);
        return JSON.toJSONString(Result.successResult(admin));
      }
      else if(status==LoginService.USERNAME_WRONG)
      {
        return JSON.toJSONString(Result.failureResult(ResultCode.USERNAME_WRONG));
      }
      else if(status==LoginService.PASSWORD_WRONG)
      {
        return JSON.toJSONString(Result.failureResult(ResultCode.PASSWORD_WRONG));
      }
      return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
    }

  }

  @PostMapping("/register")
  public String register(@RequestParam("username") String username,@RequestParam("phone") String phone,
                         @RequestParam("password") String password,@RequestParam("email") String email,
                         @RequestParam("realname") String realname,@RequestParam("forums") int[] forums)
  {
    if(!registerService.judgeEmail(email))
    {
      return JSON.toJSONString(Result.failureResult(ResultCode.EMAIL_EXIST));
    }
    if(!registerService.judgePhone(phone))
    {
      return JSON.toJSONString(Result.failureResult(ResultCode.PHONE_EXIST));
    }
    if(!registerService.judgeUsername(username))
    {
      return JSON.toJSONString(Result.failureResult(ResultCode.USERNAME_EXIST));
    }
    try
    {
      User user=new User(username,email,phone,realname, HashUtil.getHashPassword(password));
      registerService.register(user);
      for (int i:forums)
      {
        fuMapper.insertFU(user.getUid(),i);
      }
      return JSON.toJSONString(Result.successResult(user));
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
    }

  }


}
