package com.rocket.memberapi.entity;

import javax.persistence.*;

@Entity(name = "Position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_seq")
    private Long positionSeq;

    @Column(name = "name")
    private String name;
}
