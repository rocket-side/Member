package com.rocket.memberapi.entity;

import javax.persistence.*;

@Entity(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_seq")
    private Long roleSeq;

    @Column(name = "name", nullable = false, length = 10)
    private String name;
}
