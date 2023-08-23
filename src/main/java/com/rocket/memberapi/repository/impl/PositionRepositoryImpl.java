package com.rocket.memberapi.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rocket.memberapi.entity.QMember;
import com.rocket.memberapi.entity.QMemberPosition;
import com.rocket.memberapi.entity.QPosition;
import com.rocket.memberapi.repository.custom.PositionRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PositionRepositoryImpl implements PositionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<String> getPosition(Long memberSeq) {
        QMember member = QMember.member;
        QPosition position = QPosition.position;
        QMemberPosition memberPosition = QMemberPosition.memberPosition;

        return queryFactory.select(position.name)
                .from(member)
                .join(memberPosition)
                .join(memberPosition.member, member)
                .join(memberPosition.position, position)
                .where(member.memberSeq.eq(memberSeq))
                .fetch();
    }

    @Override
    public void registerPosition(Long memberSeq, Long positionSeq) {
        QMemberPosition memberPosition = QMemberPosition.memberPosition;

        queryFactory
                .insert(memberPosition)
                .set(memberPosition.member.memberSeq, memberSeq)
                .set(memberPosition.position.positionSeq, positionSeq)
                .execute();
    }

    @Override
    public void deletePosition(Long memberSeq, Long positionSeq) {
        QMemberPosition memberPosition = QMemberPosition.memberPosition;

        queryFactory
                .delete(memberPosition)
                .where(memberPosition.member.memberSeq.eq(memberSeq)
                        .and(memberPosition.position.positionSeq.eq(positionSeq)))
                .execute();
    }
}
