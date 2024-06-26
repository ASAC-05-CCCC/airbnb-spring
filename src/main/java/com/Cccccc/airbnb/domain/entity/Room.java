package com.Cccccc.airbnb.domain.entity;

import com.Cccccc.airbnb.domain.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String title;

    private String subTitle;

    private String price;

    private Boolean guest_favorite;

    private Integer maxPeopleCount;

    private Integer bathroomCount;

    private String description;

    private float latitude;

    private float longitude;

    private String country;

    private String city;

    private String region_name_1;

    private String region_name_2;

    private String address_name;

    private String image_url_1;

    private String image_url_2;

    private String image_url_3;

    private String image_url_4;

    private String image_url_5;
}
