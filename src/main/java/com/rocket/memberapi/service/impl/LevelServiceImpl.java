package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.response.LevelResponseDto;
import com.rocket.memberapi.entity.Level;
import com.rocket.memberapi.repository.LevelRepository;
import com.rocket.memberapi.repository.MemberRepository;
import com.rocket.memberapi.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;

    private final MemberRepository memberRepository;

    @Override
    public LevelResponseDto getLevel(Long memberSeq) {
        Level level = levelRepository.getLevel(memberSeq);
        LevelResponseDto levelResponseDto = new LevelResponseDto();
        levelResponseDto.setName(level.getName());
        levelResponseDto.setLevelSeq(level.getLevelSeq());
        return levelResponseDto;
    }
}
