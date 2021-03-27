package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.pojo.Result;
import com.team.ms.pojo.ResultCode;
import com.team.ms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController
{
  @Autowired
  private UserService userService;

  @PostMapping("/followForum")
  public String followForum(@RequestParam("uid") String uid,@RequestParam("fid") int fid)
  {
    if(userService.followForum(uid,fid))
    {
      return JSON.toJSONString(Result.successResult());
    }
    else
    {
      return JSON.toJSONString(Result.successResult(ResultCode.UNKNOWN_WRONG));
    }
  }

}
