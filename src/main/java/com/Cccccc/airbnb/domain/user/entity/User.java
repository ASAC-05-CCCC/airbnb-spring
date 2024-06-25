package com.Cccccc.airbnb.domain.user.entity;

import com.Cccccc.airbnb.domain.entity.BaseEntity;
import com.Cccccc.airbnb.domain.user.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="users")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Boolean isSuperHost;

    private LocalDateTime hostSince;

    private String country;

    private String location;

    private String phoneNumber;

    private String email;
}
