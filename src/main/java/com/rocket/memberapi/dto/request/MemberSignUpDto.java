package com.rocket.memberapi.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignUpDto {

    private String email;

    private String password;

    private LocalDateTime lastAccessAt;

    private String nickname;

    private String phoneNumber;

    private String info;

    private String isOnline;

    private String githubLink;

    private Long roleSeq;

    private Long levelSeq;
}
