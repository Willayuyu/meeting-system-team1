package com.team.ms.service.register;

public interface RegisterService
{
  /**
   * 判断用户名是否合法
   * @param username
   * @return
   */
  boolean judgeUsername(String username);

  /**
   * 判断邮箱是否合法
   * @param email
   * @return
   */
  boolean judgeEmail(String email);

  /**
   * 判断手机号是否合法
   * @param phone
   * @return
   */
  boolean judgePhone(String phone);


}
