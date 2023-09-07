package com.rocket.memberapi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Member_Preference")
public class MemberPreference {

    @EmbeddedId
    private PK pk;

    @ManyToOne
    @MapsId("memberSeq")
    @JoinColumn(name = "member_seq")
    private Member member;

    @ManyToOne
    @MapsId("preferenceSeq")
    @JoinColumn(name = "preference_seq")
    private Preference preference;

    @Embeddable
    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    public static class PK implements Serializable {

        @Column(name = "member_seq")
        private Long memberSeq;

        @Column(name = "preference_seq")
        private Long preferenceSeq;
    }
}
