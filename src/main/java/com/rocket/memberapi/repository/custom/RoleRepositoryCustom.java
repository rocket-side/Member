package com.rocket.memberapi.repository.custom;

import com.rocket.memberapi.entity.Role;

public interface RoleRepositoryCustom {

    Role getRole(Long memberSeq);
}
