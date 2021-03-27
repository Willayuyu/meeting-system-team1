package com.team.ms.service.forum;


import com.team.ms.pojo.Forum;

import java.util.List;

public interface ForumService {
    void insertForum(Forum forum);
    //获取一个论坛的参会人数
    int getOneForumparticipants(String cid);

    List<Integer> getAllFid();

    String getForumNameByFid(int fid);

    String getForumNameByCid(String cid);
}
