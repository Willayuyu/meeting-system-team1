package com.team.ms.utils;


import org.apache.commons.codec.digest.DigestUtils;

public class HashUtil
{
  public static String getHashPassword(String password)
  {
    return DigestUtils.sha3_256Hex(password+getHashSalt(password));
  }

  public static String getHashSalt(String password)
  {
    return DigestUtils.sha3_256Hex(password);
  }


}
