package com.team.ms.test;

import com.team.ms.dao.FUMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class FUMapperTest {

    @Autowired
    FUMapper fuMapper;

    @Test
    public void insertFUTest(){
        String UID = "id";
        int FID = 1;
        //测试随机数据
        for(int i = 0;i < 5;i++){
            fuMapper.insertFU(UID+i,FID+i);
        }
    }

    @Test
    public void deleteFUByUidTest(){
        String UID = "id";
        //测试随机数据
        for(int i = 0;i < 5;i++){
            fuMapper.deleteFUByUid(UID+i);
        }
    }

    @Test
    public void deleteFUByFidTest(){
        int FID = 1;
        //测试随机数据
        for(int i = 0;i < 5;i++){
            fuMapper.deleteFUByFid(FID+i);
        }
    }

    @Test
    public void deleteFUByFUidTest(){
        String UID = "id";
        int FID = 1;
        //测试随机数据
        for(int i = 0;i < 5;i++){
            fuMapper.deleteFUByFUid(UID+i,FID+i);
        }
    }
}
