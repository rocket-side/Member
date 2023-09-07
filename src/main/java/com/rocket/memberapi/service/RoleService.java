package com.rocket.memberapi.service;

import com.rocket.memberapi.dto.response.RoleResponseDto;

public interface RoleService {

    RoleResponseDto getRole(Long memberSeq);
}
