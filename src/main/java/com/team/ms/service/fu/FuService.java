package com.team.ms.service.fu;

import org.springframework.stereotype.Service;

@Service
public interface FuService {
    int getParticipantsNumByFid(String fid);
}
