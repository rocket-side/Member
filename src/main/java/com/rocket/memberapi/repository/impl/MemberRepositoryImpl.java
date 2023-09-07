package com.rocket.memberapi.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rocket.memberapi.entity.Member;
import com.rocket.memberapi.entity.QMember;
import com.rocket.memberapi.repository.custom.MemberRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Boolean existById(String email) {
        QMember member = QMember.member;

        Integer fetchOne = queryFactory
                .selectOne()
                .from(member)
                .where(member.email.eq(email))
                .fetchFirst();

        return fetchOne != null;
    }
}
