package com.rocket.memberapi.entity;

import com.rocket.memberapi.dto.request.MemberSignUpDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "Member")
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "member_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "password", nullable = false, length = 60)
    private String password;

    @Column(name = "lastaccessat", nullable = false)
    private LocalDateTime lastAccessAt;

    @Column(name = "nickname", nullable = false, length = 45)
    private String nickname;

    @Column(name = "phone_number", nullable = false, length = 11)
    private String phoneNumber;

    @Column(name = "info", nullable = true, length = 40000)
    private String info;

    @ManyToOne
    @JoinColumn(name = "level_seq")
    private Level level;

    @Column(name = "is_online", nullable = true, length = 45)
    private String isOnline;

    @ManyToOne
    @JoinColumn(name = "role_seq")
    private Role role;

    @Column(name = "github_link", length = 200)
    private String githubLink;

    public void updateLevel(Level level) {
        this.level = level;
    }

}
