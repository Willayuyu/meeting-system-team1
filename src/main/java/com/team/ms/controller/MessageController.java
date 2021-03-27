package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.pojo.Forum;
import com.team.ms.pojo.Message;
import com.team.ms.pojo.Result;
import com.team.ms.service.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping("/insertMessage")
    public String insertMessage(@RequestBody Message message){
        messageService.insertMessage(message);
        return JSON.toJSONString(Result.successResult());
    }


}
