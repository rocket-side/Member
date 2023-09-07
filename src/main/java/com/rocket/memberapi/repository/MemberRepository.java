package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.Member;
import com.rocket.memberapi.repository.custom.MemberRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {
    Optional<Member> findById(Long Id);

    Optional<Member> findByMemberSeq(Long seq);

    Optional<Member> findByEmail(String email);
}
