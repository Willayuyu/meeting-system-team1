package com.team.ms;

import com.team.ms.dao.UserMapper;
import com.team.ms.pojo.User;
import com.team.ms.utils.HashUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MsApplicationTests
{
  @Autowired
  UserMapper userMapper;

  @Test
  void contextLoads()
  {
    userMapper.insertUser(new User("hello world","1131396332@qq.com",
        "123456789","zcx", HashUtil.getHashPassword("123456")));
  }

}
