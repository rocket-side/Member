package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.request.PositionRequestDto;
import com.rocket.memberapi.dto.response.PositionResponseDto;
import com.rocket.memberapi.repository.PositionRepository;
import com.rocket.memberapi.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Override
    public PositionResponseDto getPosition(Long memberSeq) {
        PositionResponseDto positionResponseDto = new PositionResponseDto();
        positionResponseDto.setName(positionRepository.getPosition(memberSeq));
        return positionResponseDto;
    }

    @Override
    public void registerPosition(Long memberSeq, PositionRequestDto dto) {
        for (Long seq : dto.getPositionSeqList()) {
            positionRepository.registerPosition(memberSeq, seq);
        }
    }

    @Override
    public void deletePosition(Long memberSeq, Long positionSeq) {
        positionRepository.deletePosition(memberSeq, positionSeq);
    }
}
