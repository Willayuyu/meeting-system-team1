package com.team.ms.service.forum;

import com.team.ms.pojo.Forum;
import org.springframework.beans.factory.annotation.Autowired;

public class ForumServiceImpl implements ForumService{
    @Autowired
    ForumMapper forumMapper;

    @Override
    public void insertForum(Forum forum) {
        forumMapper.insertForum(forum);
    }
}
