package com.team.ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
  private String uid; //用户id

  private String username;    //用户名

  private String email; //邮箱

  private String phone; //手机号

  private String realname;  //真实姓名

  private String password;  //密码

  private List<Forum> forums;   //用户关注的分论坛

  /**
   * 生成新对象
   * @param username
   * @param email
   * @param phone
   * @param realname
   * @param password
   */
  public User(String username, String email, String phone,
              String realname, String password)
  {
    this.uid= UUID.randomUUID().toString();
    this.username = username;
    this.email = email;
    this.phone = phone;
    this.realname = realname;
    this.password = password;
  }

  @Override
  public String toString() {
    return "User{" +
        "uid='" + uid + '\'' +
        ", username='" + username + '\'' +
        ", email='" + email + '\'' +
        ", phone='" + phone + '\'' +
        ", realname='" + realname + '\'' +
        ", password='" + password + '\'' +
        ", forums=" + forums +
        '}';
  }
}
