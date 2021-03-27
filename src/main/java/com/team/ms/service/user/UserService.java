package com.team.ms.service.user;

import com.team.ms.pojo.User;

import java.util.List;

public interface UserService
{
  /**
   * 关注分论坛
   * @param uid
   * @param fid
   * @return
   */
  boolean followForum(String uid,int fid);

  List<User> selectUsersByForum(String forumname);
  int getTotalParticipants();
}
