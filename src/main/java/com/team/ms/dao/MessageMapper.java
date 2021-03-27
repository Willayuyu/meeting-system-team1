package com.team.ms.dao;

import com.team.ms.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    List<Message> selectMessage();
    List<Message> selectMessageByPublisher(String publisher);
    List<Message> selectMessageById(String mid);
    void insertMessage(Message message);
    void deleteMessageById(String mid);
    void updateMessageById(Message message);
}
