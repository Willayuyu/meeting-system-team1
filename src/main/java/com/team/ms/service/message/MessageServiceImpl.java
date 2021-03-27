package com.team.ms.service.message;

import com.team.ms.dao.MessageMapper;
import com.team.ms.pojo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl {
    @Autowired
    MessageMapper messageMapper;
    public void insertMessage(Message message){
        messageMapper.insertMessage(message);
    }
}
