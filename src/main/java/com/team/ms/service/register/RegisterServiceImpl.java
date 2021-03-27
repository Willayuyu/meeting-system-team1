package com.team.ms.service.register;

import com.team.ms.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService
{
  @Autowired
  private UserMapper userMapper;

  @Override
  public boolean judgeUsername(String username)
  {
    return !userMapper.isUsernameExist(username);
  }

  @Override
  public boolean judgeEmail(String email)
  {
    return !userMapper.isEmailExist(email);
  }

  @Override
  public boolean judgePhone(String phone)
  {
    return !userMapper.isPhoneExist(phone);
  }
}
