package com.team.ms.service.user;

import com.team.ms.dao.FUMapper;
import com.team.ms.dao.UserMapper;
import com.team.ms.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
  @Autowired
  private FUMapper fuMapper;
  @Autowired
  UserMapper userMapper;
  @Override
  public List<User> selectUsersByForum(String forumname) {
    return userMapper.selectUsersByForum(forumname);
  }
  @Override
  public int getTotalParticipants() {
    return userMapper.getTotalParticipants();
  }

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
