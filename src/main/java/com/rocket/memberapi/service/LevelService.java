package com.rocket.memberapi.service;

import com.rocket.memberapi.dto.response.LevelResponseDto;

public interface LevelService {
    LevelResponseDto getLevel(Long memberSeq);
}
