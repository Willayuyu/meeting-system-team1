package com.team.ms.controller;

import com.alibaba.fastjson.JSON;
import com.team.ms.pojo.Admin;
import com.team.ms.pojo.Result;
import com.team.ms.pojo.ResultCode;
import com.team.ms.pojo.User;
import com.team.ms.service.forum.ForumService;
import com.team.ms.service.fu.FuService;
import com.team.ms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class UserController
{
  @Autowired
  private UserService userService;

  @Autowired
  private ForumService forumService;
  @Autowired
  private FuService fuService;

  @RequestMapping("/selectUsersByForum")
  public String selectUsersByForum(@RequestParam("formname") String formname){
    try {
      List<User> users = userService.selectUsersByForum(formname);
      return JSON.toJSONString(Result.successResult(users));
    } catch (Exception e) {
      return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
    }
  }
  //获取总参会人数
  @RequestMapping("/getTotalParticipants")
  public String getTotalParticipants(){
    try {
      int totalParticipants=userService.getTotalParticipants();
      return JSON.toJSONString(Result.successResult(totalParticipants));
    } catch (Exception e) {
      return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
    }
  }

  //获取论坛参会人数
  @RequestMapping("/getForumparticipants")
  public String getForumparticipants(HttpSession httpSession){
    try {
      Admin admin = (Admin) httpSession.getAttribute("admin");
      int role = admin.getRole();
      List<Map<String,Object>> maps=new ArrayList<>();
      if (role== Admin.MEETING_CHAIRMAN){
        List<String> fids=forumService.getAllFid();
        for (int i = 0; i < fids.size(); i++) {
          Map<String,Object> map=new HashMap<>();
          map.put("forumname",forumService.getForumNameByFid(fids.get(i)));
          map.put("forumparticpants",fuService.getParticipantsNumByFid(fids.get(i)));
          maps.add(map);
        }
      }
      else if(role==Admin.FORUM_CHAIRMAN){
        Map<String,Object> map=new HashMap<>();
        map.put("forumname",forumService.getForumNameByCid(admin.getAid()));
        map.put("forumparticpants",forumService.getOneForumparticipants(admin.getAid()));
        maps.add(map);
      }
      return JSON.toJSONString(Result.successResult(maps));
    } catch (Exception e) {
      return JSON.toJSONString(Result.failureResult(ResultCode.UNKNOWN_WRONG));
    }
  }
  @PostMapping("/followForum")
  public String followForum(@RequestParam("uid") String uid,@RequestParam("fid") int fid)
  {
    if(userService.followForum(uid,fid))
    {
      return JSON.toJSONString(Result.successResult());
    }
    else
    {
      return JSON.toJSONString(Result.successResult(ResultCode.UNKNOWN_WRONG));
    }
  }

}
