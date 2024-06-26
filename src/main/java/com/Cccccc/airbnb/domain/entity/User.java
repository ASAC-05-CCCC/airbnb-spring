package com.Cccccc.airbnb.domain.entity;

import com.Cccccc.airbnb.domain.entity.common.UserRole;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name= "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    private Boolean superhost;

    private LocalDateTime hostSince;

    private String country;

    private String location;

    private String phoneNumber;

    private String email;
}
