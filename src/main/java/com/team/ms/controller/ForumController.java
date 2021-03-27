package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.pojo.Forum;
import com.team.ms.pojo.Result;
import com.team.ms.pojo.ResultCode;
import com.team.ms.service.forum.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ForumController {
    @Autowired
    ForumService forumService;
    @PostMapping("/insertForum")
    public String insertForum(@RequestBody Forum forum)
    {
        try {
            forumService.insertForum(forum);
            return JSON.toJSONString(Result.successResult());
        } catch (Exception e) {
            return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
        }
    }
}
