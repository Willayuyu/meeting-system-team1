package com.team.ms.service.forum;

import com.team.ms.dao.ForumMapper;
import com.team.ms.pojo.Forum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService{
    @Autowired
    ForumMapper forumMapper;

    @Override
    public void insertForum(Forum forum) {
        forumMapper.insertForum(forum);
    }
    @Override
    public int getOneForumparticipants(String cid) {
        return forumMapper.getOneForumparticipants(cid);
    }

    @Override
    public List<String> getAllFid() {
        return forumMapper.getAllFid();
    }

    @Override
    public String getForumNameByFid(String fid) {
        return forumMapper.getForumNameByFid(fid);
    }

    @Override
    public String getForumNameByCid(String cid) {
        return forumMapper.getForumNameByCid(cid);
    }
}
