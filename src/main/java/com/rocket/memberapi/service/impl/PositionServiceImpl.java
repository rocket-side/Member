package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.request.PositionRequestDto;
import com.rocket.memberapi.dto.response.PositionResponseDto;
import com.rocket.memberapi.entity.Member;
import com.rocket.memberapi.entity.MemberPosition;
import com.rocket.memberapi.entity.Position;
import com.rocket.memberapi.repository.MemberPositionRepository;
import com.rocket.memberapi.repository.MemberRepository;
import com.rocket.memberapi.repository.PositionRepository;
import com.rocket.memberapi.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    private final MemberRepository memberRepository;

    private final MemberPositionRepository memberPositionRepository;

    @Override
    public PositionResponseDto getPosition(Long memberSeq) {
        PositionResponseDto positionResponseDto = new PositionResponseDto();
        positionResponseDto.setName(positionRepository.getPosition(memberSeq));
        return positionResponseDto;
    }

    @Override
    public void registerPosition(Long memberSeq, PositionRequestDto dto) {
        for (Long seq : dto.getPositionSeqList()) {
//            positionRepository.registerPosition(memberSeq, seq);
            MemberPosition.PK pk = MemberPosition.PK.builder()
                    .memberSeq(memberSeq)
                    .positionSeq(seq)
                    .build();

            Member member = memberRepository.findById(memberSeq).orElseThrow();
            Position position = positionRepository.findById(seq).orElseThrow();

            MemberPosition memberPosition = MemberPosition.builder()
                    .member(member)
                    .position(position)
                    .pk(pk)
                    .build();

            memberPositionRepository.save(memberPosition);
        }
    }

    @Override
    public void deletePosition(Long memberSeq, Long positionSeq) {
//        positionRepository.deletePosition(memberSeq, positionSeq);
        MemberPosition.PK pk = MemberPosition.PK.builder()
                .positionSeq(positionSeq)
                .memberSeq(memberSeq)
                .build();

        memberPositionRepository.deleteById(pk);
    }
}
