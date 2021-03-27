package com.team.ms.service.login;

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
  int judgeToken(String username,String password);



}
