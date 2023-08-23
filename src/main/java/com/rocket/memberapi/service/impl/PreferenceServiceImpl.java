package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.request.PreferenceRequestDto;
import com.rocket.memberapi.dto.response.PreferenceResponseDto;
import com.rocket.memberapi.repository.PreferenceRepository;
import com.rocket.memberapi.service.PreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    @Override
    public PreferenceResponseDto getPreference(Long memberSeq) {
        PreferenceResponseDto dto = new PreferenceResponseDto();
        dto.setName(preferenceRepository.getPreference(memberSeq));
        return dto;
    }

    @Override
    public void registerPreference(Long memberSeq, PreferenceRequestDto dto) {
        for (Long seq : dto.getPreferenceSeq()) {
            preferenceRepository.registerPreference(memberSeq, seq);
        }
    }

    @Override
    public void deletePreference(Long memberSeq, Long preferenceSeq) {
        preferenceRepository.deletePreference(memberSeq, preferenceSeq);
    }
}
