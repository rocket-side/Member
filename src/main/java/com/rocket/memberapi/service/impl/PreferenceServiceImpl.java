package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.request.PreferenceRequestDto;
import com.rocket.memberapi.dto.response.PreferenceResponseDto;
import com.rocket.memberapi.entity.Member;
import com.rocket.memberapi.entity.MemberPreference;
import com.rocket.memberapi.entity.Preference;
import com.rocket.memberapi.repository.MemberPreferenceRepository;
import com.rocket.memberapi.repository.MemberRepository;
import com.rocket.memberapi.repository.PreferenceRepository;
import com.rocket.memberapi.service.PreferenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PreferenceServiceImpl implements PreferenceService {

    private final PreferenceRepository preferenceRepository;

    private final MemberRepository memberRepository;

    private final MemberPreferenceRepository memberPreferenceRepository;


    @Override
    public PreferenceResponseDto getPreference(Long memberSeq) {
        PreferenceResponseDto dto = new PreferenceResponseDto();
        dto.setName(preferenceRepository.getPreference(memberSeq));
        return dto;
    }

    @Override
    public void registerPreference(Long memberSeq, PreferenceRequestDto dto) {
        for (Long seq : dto.getPreferenceSeq()) {
//            preferenceRepository.registerPreference(memberSeq, seq);
            MemberPreference.PK pk = MemberPreference.PK.builder()
                    .preferenceSeq(seq)
                    .memberSeq(memberSeq)
                    .build();

            Member member = memberRepository.findById(memberSeq).orElseThrow();
            Preference preference = preferenceRepository.findById(seq).orElseThrow();

            MemberPreference memberPreference = MemberPreference.builder()
                    .member(member)
                    .preference(preference)
                    .pk(pk)
                    .build();

            memberPreferenceRepository.save(memberPreference);
        }
    }

    @Override
    public void deletePreference(Long memberSeq, Long preferenceSeq) {
//        preferenceRepository.deletePreference(memberSeq, preferenceSeq);
        MemberPreference.PK pk = MemberPreference.PK.builder()
                .memberSeq(memberSeq)
                .preferenceSeq(preferenceSeq)
                .build();

        memberPreferenceRepository.deleteById(pk);
    }
}
