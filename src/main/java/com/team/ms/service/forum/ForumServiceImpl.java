package com.team.ms.service.forum;

import com.team.ms.dao.ForumMapper;
import com.team.ms.pojo.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForumServiceImpl implements ForumService{
    @Autowired
    ForumMapper forumMapper;

    @Override
    public void insertForum(Forum forum) {
        forumMapper.insertForum(forum);
    }
}
