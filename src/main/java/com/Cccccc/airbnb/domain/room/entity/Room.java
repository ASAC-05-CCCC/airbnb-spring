package com.Cccccc.airbnb.domain.room.entity;

import com.Cccccc.airbnb.domain.entity.BaseEntity;
import com.Cccccc.airbnb.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    private String title;

    private String subTitle;

    private String price;

    private String guestFavorite;

    private Integer maxPeopleCount;

    private Integer bathroomCount;

    private String description;

    private float latitude;

    private float longitude;

    private String country;

    private String city;

    private String regionName1;

    private String regionName2;

    private String addressName;

    private String imageUrl1;

    private String imageUrl2;

    private String imageUrl3;

    private String imageUrl4;

    private String imageUrl5;
}
