package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.MemberPosition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPositionRepository extends JpaRepository<MemberPosition, MemberPosition.PK> {
}
