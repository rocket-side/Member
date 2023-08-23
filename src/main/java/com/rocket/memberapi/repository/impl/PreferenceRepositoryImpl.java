package com.rocket.memberapi.repository.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.rocket.memberapi.entity.QMember;
import com.rocket.memberapi.entity.QMemberPreference;
import com.rocket.memberapi.entity.QPreference;
import com.rocket.memberapi.repository.custom.PreferenceRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PreferenceRepositoryImpl implements PreferenceRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<String> getPreference(Long memberSeq) {
        QMember member = QMember.member;
        QPreference preference = QPreference.preference;
        QMemberPreference memberPreference = QMemberPreference.memberPreference;

        return queryFactory
                .select(preference.name)
                .from(member)
                .join(memberPreference)
                .join(memberPreference.member, member)
                .join(memberPreference.preference, preference)
                .where(member.memberSeq.eq(memberSeq))
                .fetch();
    }

    @Override
    public void registerPreference(Long memberSeq, Long preferenceSeq) {
        QMemberPreference memberPreference = QMemberPreference.memberPreference;

        queryFactory
                .insert(memberPreference)
                .set(memberPreference.member.memberSeq, memberSeq)
                .set(memberPreference.preference.preference_seq, preferenceSeq)
                .execute();
    }

    @Override
    public void deletePreference(Long memberSeq, Long preferenceSeq) {
        QMemberPreference memberPreference = QMemberPreference.memberPreference;

        queryFactory
                .delete(memberPreference)
                .where(memberPreference.member.memberSeq.eq(memberSeq)
                        .and(memberPreference.preference.preference_seq.eq(preferenceSeq)))
                .execute();
    }
}
