package com.Cccccc.airbnb.domain.review.entity;

import com.Cccccc.airbnb.domain.entity.BaseEntity;
import com.Cccccc.airbnb.domain.room.entity.Room;
import com.Cccccc.airbnb.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    private Integer cleanliness;
    private Integer accuracy;
    private Integer checkin;
    private Integer communication;
    private Integer location;
    private Integer price;
    private String content;
}
