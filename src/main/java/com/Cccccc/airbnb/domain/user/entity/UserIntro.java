package com.Cccccc.airbnb.domain.user.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserIntro {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserIntroCategory userIntroCategory;

    private String content;
}
