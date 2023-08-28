package com.rocket.memberapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MemberLoginResponseDto {

    private Long memberSeq;

    private String email;

    private String nickname;

    private String password;

    private RoleResponseDto roleResponseDto;
}
