package com.rocket.memberapi.dto.response;

import com.rocket.memberapi.entity.Level;
import com.rocket.memberapi.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponseDto {

    private Long memberSeq;

    private String email;

    private LocalDateTime lastAccessAt;

    private String nickname;

    private String phoneNumber;

    private String info;

    private RoleResponseDto role;

    private LevelResponseDto level;

    private String githubLink;
}
