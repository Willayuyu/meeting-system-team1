package com.team.ms.service.fu;

import com.team.ms.dao.FUMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuServiceImpl implements FuService{
    @Autowired
    FUMapper fuMapper;
    @Override
    public int getParticipantsNumByFid(String fid) {
        return fuMapper.getParticipantsNumByFid(fid);
    }
}
