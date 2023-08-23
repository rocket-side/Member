package com.rocket.memberapi.service;

import com.rocket.memberapi.dto.request.MemberSignUpDto;
import com.rocket.memberapi.dto.response.MemberResponseDto;

public interface MemberService {

    Boolean existById(String email);

    void memberSignUp(MemberSignUpDto dto);

    MemberResponseDto findByMemberSeq(Long seq);

    MemberResponseDto findByEmail(String email);

    void memberUpdate(Long seq, MemberSignUpDto dto);

    void memberDelete(Long seq);

    void updateLevel(Long memberSeq, Long levelSeq);
}
