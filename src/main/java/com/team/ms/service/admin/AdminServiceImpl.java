package com.team.ms.service.admin;

import com.team.ms.dao.AdminMapper;
import com.team.ms.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;
    @Override
    public void insertAdmin(Admin admin) {
        adminMapper.insertAdmin(admin);
    }
}
