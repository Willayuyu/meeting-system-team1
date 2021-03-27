package com.team.ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message
{
  private int mid;  //消息id

  private int fid;  //所属论坛编号

  private String title; //标题

  private Timestamp createtime; //创建时间

  private String content;   //消息内容

  private String publisher;   //发布者id

  /**
   * 生成新对象
   * @param fid
   * @param title
   * @param createtime
   * @param content
   * @param publisher
   */
  public Message(int fid, String title, Timestamp createtime,
                  String content, String publisher)
  {
    this.fid = fid;
    this.title = title;
    this.createtime = createtime;
    this.content = content;
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return "Message{" +
        "mid=" + mid +
        ", fid=" + fid +
        ", title='" + title + '\'' +
        ", createtime=" + createtime +
        ", content='" + content + '\'' +
        ", publisher='" + publisher + '\'' +
        '}';
  }
}
