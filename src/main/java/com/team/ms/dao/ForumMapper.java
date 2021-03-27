package com.team.ms.dao;

import com.team.ms.pojo.Forum;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ForumMapper {

    void insertForum(Forum forum);

    void deleteForumById(String fid);

    void updateByObject(Forum forum);

    void updateByMap(Map params);

    Forum selectForumById(String fid);

    List<Forum> selectForumByMap(Map params);


}