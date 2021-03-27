package com.team.ms.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FUMapper
{
  void insertFU(String uid,int fid);

  void deleteFUByUid(String uid);

  void deleteFUByFid(int fid);

  void deleteFUByFUid(String uid,int fid);

}
