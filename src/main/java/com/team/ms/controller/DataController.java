package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.dao.ForumMapper;
import com.team.ms.pojo.Forum;
import com.team.ms.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
public class DataController
{
  @Autowired
  private ForumMapper forumMapper;

  @GetMapping("/getAllForums")
  public String getAllForums()
  {
    Map<String,Object> params=new HashMap<>();
    return JSON.toJSONString(Result.successResult(forumMapper.selectForumByMap(params)));
  }

  @GetMapping("/forum/{id}")
  public String getForumById(@PathVariable("id") String fid)
  {
    return JSON.toJSONString(Result.successResult(forumMapper.selectForumById(fid)));
  }


}
