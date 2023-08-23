package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.response.RoleResponseDto;
import com.rocket.memberapi.repository.RoleRepository;
import com.rocket.memberapi.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleResponseDto getRole(Long memberSeq) {
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setName(roleRepository.getRole(memberSeq));
        return roleResponseDto;
    }
}
