package com.team.ms.dao;

import com.team.ms.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdminMapper
{
  void insertAdmin(Admin admin);

  void deleteAdminById(String aid);

  void updateByObject(Admin admin);

  void updateByMap(Map params);

  Admin selectAdminById(String aid);

  List<Admin> selectAdminsByMap(Map params);
}
