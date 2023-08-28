package com.rocket.memberapi.service.impl;

import com.rocket.memberapi.dto.response.RoleResponseDto;
import com.rocket.memberapi.entity.Role;
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
        Role role = roleRepository.getRole(memberSeq);
        RoleResponseDto roleResponseDto = new RoleResponseDto();
        roleResponseDto.setName(role.getName());
        roleResponseDto.setRoleSeq(role.getRoleSeq());
        return roleResponseDto;
    }
}
