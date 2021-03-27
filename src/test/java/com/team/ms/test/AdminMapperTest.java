package com.team.ms.test;

import com.team.ms.dao.AdminMapper;
import com.team.ms.dao.ForumMapper;
import com.team.ms.pojo.Admin;
import com.team.ms.pojo.Forum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
public class AdminMapperTest
{
  @Autowired
  AdminMapper adminMapper;

  @Autowired
  ForumMapper forumMapper;

  @Test
  void insertAdminTest()
  {
//    for(int i=0;i<5;i++)
//    {
//      Admin admin=new Admin("admin"+(i+1),"xxxxx","administator"+(i+1),1);
//      adminMapper.insertAdmin(admin);
//    }

    for(int i=0;i<10;i++)
    {
      Forum forum=new Forum("分论坛"+i, UUID.randomUUID().toString(),"3月"+(i+1)+"号","东"+(i+1)+"楼","hhhhh","xxxxxxxxxxxxxxxxxxxxxx");
      forumMapper.insertForum(forum);
    }
  }

  @Test
  void deleteAdminByIdTest(String pid)
  {
    adminMapper.deleteAdminById("213");
  }



//  void updateByObject(Admin admin);
//
//  void updateByMap(Map params);
//
//  Admin selectAdminById(String aid);
//
//  List<Admin> selectAdminsByMap(Map params);
}
