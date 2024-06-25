package com.Cccccc.airbnb.domain.room.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RoomRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Room room;
    private float rating;
    private Integer review_count;
    private Integer cleanliness;
    private Integer accuracy;
    private Integer checkin;
    private Integer communication;
    private Integer location;
    private Integer value;
}
