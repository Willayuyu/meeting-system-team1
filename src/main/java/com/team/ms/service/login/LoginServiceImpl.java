package com.team.ms.service.login;

import com.team.ms.dao.AdminMapper;
import com.team.ms.dao.UserMapper;
import com.team.ms.pojo.Admin;
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

  @Autowired
  private AdminMapper adminMapper;

  @Override
  public int judgeUserToken(String username, String password)
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
  public int judgeAdminToken(String username, String password)
  {
    Admin admin=getAdminByLoginName(username);
    if(admin!=null)
    {
      if(HashUtil.getHashPassword(password).equals(admin.getPassword()))
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

  @Override
  public Admin getAdminByLoginName(String loginName)
  {
    Map<String,Object> params=new HashMap<>();
    params.put("username",loginName);
    return adminMapper.selectAdminsByMap(params).get(0);
  }
}
