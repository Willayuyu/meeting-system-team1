package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.pojo.Forum;
import com.team.ms.pojo.Result;
import com.team.ms.service.forum.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class ForumController {
    @Autowired
    ForumService forumService;
    @RequestMapping("/insertForum")
    public String insertForum(@RequestBody Forum forum)
    {
        forumService.createForum(forum);
        return JSON.toJSONString(Result.successResult());
    }
}
