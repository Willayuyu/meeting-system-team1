package com.team.ms.service.login;

import com.team.ms.pojo.Admin;
import com.team.ms.pojo.User;

public interface LoginService
{
  int CORRECT=1;
  int USERNAME_WRONG=2;
  int PASSWORD_WRONG=3;

  /**
   * 判断用户登录token
   * @param username
   * @param password
   * @return
   */
  int judgeUserToken(String username,String password);

  /**
   * 判断管理员登录token
   * @param username
   * @param password
   * @return
   */
  int judgeAdminToken(String username,String password);

  /**
   * 通过登录名获取user
   * @param loginName
   * @return
   */
  User getUserByLoginName(String loginName);


  /**
   * 通过登录名获取admin
   * @param loginName
   * @return
   */
  Admin getAdminByLoginName(String loginName);
}
