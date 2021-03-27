package com.team.ms.test;

import com.team.ms.dao.MessageMapper;
import com.team.ms.pojo.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
public class MessageMapperTest {

    @Autowired
    MessageMapper messageMapper;

    @Test
    public void selectMessageTest(){
        List<Message> list = messageMapper.selectMessage();
        //测试输出结果
        for(Message message: list){
            System.out.println(message.getContent());
        }
    }

    @Test
    public void selectMessageByPublisherTest(){
        String publisher = "publisher";
        List<Message> list = messageMapper.selectMessageByPublisher(publisher);
        //测试输出结果
        for(Message message: list){
            System.out.println(message.getContent());
        }
    }

    @Test
    public void selectMessageByIdTest(){
        String MID = "mid";
        List<Message> list = messageMapper.selectMessageById(MID);
        //测试输出结果
        for(Message message: list){
            System.out.println(message.getContent());
        }
    }

    @Test
    public void insertMessageTest(){
        //测试正常数据
        Message message = new Message();
        message.setMid(1);
        message.setFid(1);
        message.setContent("content");
        message.setCreatetime(new Timestamp(System.currentTimeMillis()));
        message.setTitle("title");
        messageMapper.insertMessage(message);
        //测试不存在数据
        message = new Message();
        message.setMid(-1);
        message.setFid(-1);
        message.setContent("");
        message.setCreatetime(new Timestamp(System.currentTimeMillis()));
        message.setTitle("");
        messageMapper.insertMessage(message);
    }

    @Test
    public void deleteMessageByIdTest(){
        //测试删除正常数据
        String MID = "id";
        messageMapper.deleteMessageById(MID);
        //测试删除空数据
        MID = "";
        messageMapper.deleteMessageById(MID);
    }

    @Test
    public void updateMessageByIdTest(){
        //测试正常数据
        Message message = new Message();
        message.setMid(1);
        message.setFid(1);
        message.setContent("content");
        message.setCreatetime(new Timestamp(System.currentTimeMillis()));
        message.setTitle("title");
        messageMapper.updateMessageById(message);
        //测试不存在数据
        message = new Message();
        message.setMid(-1);
        message.setFid(-1);
        message.setContent("");
        message.setCreatetime(new Timestamp(System.currentTimeMillis()));
        message.setTitle("");
        messageMapper.updateMessageById(message);
    }
}
