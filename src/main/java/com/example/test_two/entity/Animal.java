package com.example.test_two.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "animals")
@Getter
@Setter
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "a_id")
    private int id;

    @Column(name = "a_nickname")
    private String nickname;

    @Column(name = "a_gender")
    private String gender;

    @Column(name = "a_birthday")
    private LocalDate birthday;

    @Column(name = "a_type")
    @Enumerated(EnumType.STRING)
    private EAnimal type;

    public Animal() {
    }

    public Animal(String nickname, String gender,
                  LocalDate birthday, EAnimal type) {
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;
        this.type = type;
    }
}
