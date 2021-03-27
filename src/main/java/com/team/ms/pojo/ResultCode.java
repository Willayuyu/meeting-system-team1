package com.team.ms.pojo;

public enum ResultCode
{
  SUCCESS(1,"请求成功~");

  //状态码
  private Integer code;
  //状态描述
  private String message;

  /**
   * 构造方法
   * @param code
   * @param message
   */
  ResultCode(Integer code, String message)
  {
    this.code = code;
    this.message = message;
  }

  //get、set
  public Integer getCode()
  {
    return code;
  }

  public void setCode(Integer code)
  {
    this.code = code;
  }

  public String getMessage()
  {
    return message;
  }

  public void setMessage(String message)
  {
    this.message = message;
  }
}
