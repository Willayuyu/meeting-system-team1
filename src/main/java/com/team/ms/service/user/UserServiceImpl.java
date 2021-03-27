package com.team.ms.service.user;

import com.team.ms.dao.FUMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  private FUMapper fuMapper;

  @Override
  public boolean followForum(String uid, int fid)
  {
    try
    {
      fuMapper.insertFU(uid, fid);
      return true;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      return false;
    }
  }
}
