package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.Member;
import com.rocket.memberapi.repository.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
}
