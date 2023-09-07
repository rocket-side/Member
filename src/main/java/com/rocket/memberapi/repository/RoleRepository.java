package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.Role;
import com.rocket.memberapi.repository.custom.RoleRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>, RoleRepositoryCustom {
}
