package com.team.ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Forum
{
  private int fid;      //分论坛id

  private String forumname; //分论坛名

  private String cid;     //主席id

  private String holdtime;  //举办时间

  private String location;    //举报地点

  private String subject;     //论题

  private String introduction;  //介绍

  /**
   * 生成新对象
   * @param forumname
   * @param cid
   * @param holdtime
   * @param location
   * @param subject
   * @param introduction
   */
  public Forum(String forumname, String cid, String holdtime,
               String location, String subject, String introduction)
  {
    this.forumname = forumname;
    this.cid=cid;
    this.holdtime = holdtime;
    this.location = location;
    this.subject = subject;
    this.introduction = introduction;
  }


  @Override
  public String toString() {
    return "forum{" +
        "fid=" + fid +
        ", forumname='" + forumname + '\'' +
        ", cid='" + cid + '\'' +
        ", holdtime='" + holdtime + '\'' +
        ", location='" + location + '\'' +
        ", subject='" + subject + '\'' +
        ", introduction='" + introduction + '\'' +
        '}';
  }
}
