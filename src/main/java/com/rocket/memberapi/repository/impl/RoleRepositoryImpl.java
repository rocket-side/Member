package com.rocket.memberapi.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rocket.memberapi.entity.QMember;
import com.rocket.memberapi.entity.QRole;
import com.rocket.memberapi.repository.custom.RoleRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RoleRepositoryImpl implements RoleRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public String getRole(Long memberSeq) {
        QRole role = QRole.role;
        QMember member = QMember.member;

        return queryFactory
                .select(role.name)
                .from(member)
                .join(member.role, role)
                .where(member.memberSeq.eq(memberSeq))
                .fetchOne();
    }
}
