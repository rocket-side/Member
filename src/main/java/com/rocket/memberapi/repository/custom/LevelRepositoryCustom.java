package com.rocket.memberapi.repository.custom;

import com.rocket.memberapi.dto.response.LevelResponseDto;

import java.util.Optional;

public interface LevelRepositoryCustom {

    String getLevel(Long memberSeq);
}
