package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.repository.impl.MemberRepositoryImpl;
import com.rocket.memberapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

    private final MemberRepositoryImpl memberRepository;

    @Override
    public Boolean existById(Long seq) {
        return memberRepository.existById(seq);
    }
}
