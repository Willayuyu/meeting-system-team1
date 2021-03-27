package com.team.ms.service.login;

import com.team.ms.dao.UserMapper;
import com.team.ms.pojo.User;
import com.team.ms.utils.HashUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService
{
  @Autowired
  private UserMapper userMapper;

  @Override
  public int judgeToken(String username, String password)
  {
    User user=getUserByLoginName(username);
    if(user!=null)
    {
      if(HashUtil.getHashPassword(password).equals(user.getPassword()))
      {
        return CORRECT;
      }
      else
      {
        return PASSWORD_WRONG;
      }
    }
    return USERNAME_WRONG;
  }

  @Override
  public User getUserByLoginName(String loginName)
  {
    boolean flag=false;
    Map<String,Object> params=new HashMap<>();
    if(userMapper.isUsernameExist(loginName))
    {
      params.put("username",loginName);
      flag=true;
    }
    if(userMapper.isEmailExist(loginName))
    {
      params.put("email",loginName);
      flag=true;
    }
    if(userMapper.isPhoneExist(loginName))
    {
      params.put("phone",loginName);
      flag=true;
    }
    return flag?userMapper.selectUsersByMap(params).get(0):null;
  }
}
