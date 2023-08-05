package com.friends.sickseek.user.domain;

import com.friends.sickseek.shared.entity.BaseTimeEntity;
import com.friends.sickseek.shared.util.PasswordUtil;
import com.friends.sickseek.user.type.Authority;
import com.friends.sickseek.user.value.Password;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_user")
@Entity
public class User extends BaseTimeEntity {

    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(unique = true, nullable = false)
    private UUID uuid;

    @Column(unique = true, nullable = false, length = 100)
    private String email;

    @Embedded
    private Password password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private Authority authority;

    @Builder
    public User(String email, String password, Authority authority) {
        this.uuid = UUID.randomUUID();
        this.email = email;
        this.password = new Password(PasswordUtil.encode(password));
        this.authority = authority;
    }

    public boolean isAdmin() {
        return this.authority == Authority.ADMIN;
    }
}
