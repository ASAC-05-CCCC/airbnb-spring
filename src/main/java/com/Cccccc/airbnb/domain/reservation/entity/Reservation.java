package com.Cccccc.airbnb.domain.reservation.entity;

import com.Cccccc.airbnb.domain.entity.BaseEntity;
import com.Cccccc.airbnb.domain.room.entity.Room;
import com.Cccccc.airbnb.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Room room;

    private LocalDate checkIndDateTime;

    private LocalDateTime checkOutDateTime;

    private Integer childrenCount;

    private Integer infantCount;

    private Integer petCount;

    private Boolean isReservation;

    private LocalDateTime reservationTime;
}