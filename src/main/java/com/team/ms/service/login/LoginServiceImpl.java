package com.team.ms.service.login;

import com.team.ms.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService
{
  @Autowired
  private UserMapper userMapper;

  @Override
  public int judgeToken(String username, String password)
  {
    userMapper.isUsernameExist(username);
    return 0;
  }
}
