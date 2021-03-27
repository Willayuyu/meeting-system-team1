package com.team.ms.test;

import com.team.ms.dao.AdminMapper;
import com.team.ms.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class AdminMapperTest
{
  @Autowired
  AdminMapper adminMapper;

  @Test
  void insertAdminTest()
  {
    for(int i=0;i<5;i++)
    {
      Admin admin=new Admin("admin"+(i+1),"xxxxx","administator"+(i+1),1);
      adminMapper.insertAdmin(admin);
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
