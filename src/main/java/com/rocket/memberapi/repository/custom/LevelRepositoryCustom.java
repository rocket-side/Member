package com.rocket.memberapi.repository.custom;

import com.rocket.memberapi.dto.response.LevelResponseDto;
import com.rocket.memberapi.entity.Level;

import java.util.Optional;

public interface LevelRepositoryCustom {

    Level getLevel(Long memberSeq);
}
