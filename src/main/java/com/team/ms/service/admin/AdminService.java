package com.team.ms.service.admin;

import com.team.ms.pojo.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    //插入管理员
    void insertAdmin(Admin admin);
}
