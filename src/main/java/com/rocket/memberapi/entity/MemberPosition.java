package com.rocket.memberapi.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Member_Position")
public class MemberPosition {

    @EmbeddedId
    private PK pk;

    @ManyToOne
    @JoinColumn(name = "member_seq")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "position_seq")
    private Position position;

    @Embeddable
    @Getter
    @Setter
    @EqualsAndHashCode
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class PK implements Serializable {

        @Column(name = "member_seq")
        private Long memberSeq;

        @Column(name = "position_seq")
        private Long positionSeq;
    }
}
