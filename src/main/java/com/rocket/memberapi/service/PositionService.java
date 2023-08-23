package com.rocket.memberapi.service;

import com.rocket.memberapi.dto.request.PositionRequestDto;
import com.rocket.memberapi.dto.response.PositionResponseDto;

public interface PositionService {

    PositionResponseDto getPosition(Long memberSeq);

    void registerPosition(Long memberSeq, PositionRequestDto dto);

    void deletePosition(Long memberSeq, Long positionSeq);
}
