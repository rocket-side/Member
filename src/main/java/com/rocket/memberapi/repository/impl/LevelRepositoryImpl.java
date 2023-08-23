package com.rocket.memberapi.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rocket.memberapi.dto.response.LevelResponseDto;
import com.rocket.memberapi.entity.QLevel;
import com.rocket.memberapi.entity.QMember;
import com.rocket.memberapi.repository.custom.LevelRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class LevelRepositoryImpl implements LevelRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public String getLevel(Long memberSeq) {
        QLevel level = QLevel.level;
        QMember member = QMember.member;

        String levelResponseDto = queryFactory
                .select(level.name)
                .from(member)
                .join(member.level, level)
                .where(member.memberSeq.eq(memberSeq))
                .fetchOne();
        return levelResponseDto;
    }
}
