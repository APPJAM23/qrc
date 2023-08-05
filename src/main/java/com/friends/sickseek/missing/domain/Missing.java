package com.friends.sickseek.missing.domain;

import com.friends.sickseek.missing.domain.type.Gender;
import com.friends.sickseek.missing.domain.type.MissingType;
import com.friends.sickseek.user.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_missing")
@Entity
public class Missing {

    @Column(name = "missing_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String pictureUrl;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private LocalDate missingDate;

    @Column(nullable = false)
    private String missingPlace;

    private String missingClothes;

    private String specialNote;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MissingType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Missing(String pictureUrl, String name, Integer age, Gender gender, Integer height, Integer weight, LocalDate missingDate, String missingPlace, String missingClothes, String specialNote, MissingType type, User user) {
        this.pictureUrl = pictureUrl;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.missingDate = missingDate;
        this.missingPlace = missingPlace;
        this.missingClothes = missingClothes;
        this.specialNote = specialNote;
        this.type = type;
        this.user = user;
    }
}
