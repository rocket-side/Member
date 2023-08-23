package com.rocket.memberapi.service;

import com.rocket.memberapi.dto.request.PreferenceRequestDto;
import com.rocket.memberapi.dto.response.PreferenceResponseDto;

public interface PreferenceService {

    PreferenceResponseDto getPreference(Long memberSeq);

    void registerPreference(Long memberSeq, PreferenceRequestDto dto);

    void deletePreference(Long memberSeq, Long preferenceSeq);
}
