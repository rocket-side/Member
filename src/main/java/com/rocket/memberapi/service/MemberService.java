package com.rocket.memberapi.service;

import com.rocket.memberapi.dto.request.MemberSignUpDto;
import com.rocket.memberapi.dto.response.MemberLoginResponseDto;
import com.rocket.memberapi.dto.response.MemberResponseDto;

public interface MemberService {

    Boolean existById(String email);

    void memberSignUp(MemberSignUpDto dto);

    MemberResponseDto findByMemberSeq(Long seq);

    MemberLoginResponseDto findByEmail(String email);

    void memberUpdate(Long seq, MemberSignUpDto dto);

    void memberDelete(Long seq);

    void updateLevel(Long memberSeq, Long levelSeq);

    void updateRole(Long memberSeq, Long roleSeq);
}
