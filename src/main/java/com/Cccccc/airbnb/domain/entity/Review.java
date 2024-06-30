package com.Cccccc.airbnb.domain.entity;

import com.Cccccc.airbnb.domain.entity.common.BaseEntity;
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
    private Integer value;
    private String content;
    private LocalDateTime creation_date;

    public void updateContent(Integer cleanliness, Integer accuracy, Integer checkin, Integer communication, Integer location, Integer value, String content) {
        this.cleanliness = cleanliness;
        this.accuracy = accuracy;
        this.checkin = checkin;
        this.communication = communication;
        this.location = location;
        this.value = value;
        this.content = content;
    }
}
