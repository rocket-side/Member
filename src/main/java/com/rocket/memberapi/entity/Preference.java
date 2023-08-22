package com.rocket.memberapi.entity;

import javax.persistence.*;

@Entity
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Preference")
    private Long preference_seq;

    @Column(name = "name", nullable = false, length = 20)
    private String name;
}
