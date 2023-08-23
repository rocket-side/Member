package com.rocket.memberapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Preference")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Preference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Preference_seq")
    private Long preferenceSeq;

    @Column(name = "name", nullable = false, length = 20)
    private String name;
}
