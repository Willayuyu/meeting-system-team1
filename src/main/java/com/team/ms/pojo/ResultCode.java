package com.team.ms.pojo;

public enum ResultCode
{
  SUCCESS(200,"请求成功"),

  USERNAME_WRONG(401,"用户名错误"),

  PASSWORD_WRONG(402,"密码错误"),

  USERNAME_EXIST(411,"用户名存在"),

  EMAIL_EXIST(412,"邮箱已存在"),

  PHONE_EXIST(413,"电话号码已存在"),

  UNKNOWN_WRONG(500,"未知错误");

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
