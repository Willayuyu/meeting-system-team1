package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.team.ms.pojo.Result;
import com.team.ms.pojo.ResultCode;
import com.team.ms.pojo.User;
import com.team.ms.service.login.LoginService;
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

  @PostMapping("/login")
  public String login(@RequestParam("username") String username,
                      @RequestParam("password") String password, HttpSession session)
  {
    int status=loginService.judgeToken(username,password);
    if(status==LoginService.CORRECT)
    {
      User user=loginService.getUserByLoginName(username);
      session.setAttribute("user",user);
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


}
