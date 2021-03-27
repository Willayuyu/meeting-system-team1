package com.team.ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Admin
{
  private String aid;       //管理员id

  private String username;  //用户名

  private String password;  //密码

  private String realname;  //真实姓名

  private int role;         //角色

  /**
   * 生成新对象
   * @param username
   * @param password
   * @param realname
   * @param role
   */
  public Admin(String username, String password, String realname, int role)
  {
    this.aid= UUID.randomUUID().toString();
    this.username = username;
    this.password = password;
    this.realname = realname;
    this.role = role;
  }

  @Override
  public String toString() {
    return "admin{" +
        "aid='" + aid + '\'' +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", realname='" + realname + '\'' +
        ", role=" + role +
        '}';
  }
}
