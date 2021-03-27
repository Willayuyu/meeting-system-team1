package com.team.ms.service.user;

public interface UserService
{
  /**
   * 关注分论坛
   * @param uid
   * @param fid
   * @return
   */
  boolean followForum(String uid,int fid);
}
