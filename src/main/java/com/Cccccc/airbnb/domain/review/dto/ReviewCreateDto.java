package com.Cccccc.airbnb.domain.review.dto;

import com.Cccccc.airbnb.domain.entity.Review;
import com.Cccccc.airbnb.domain.entity.Room;
import com.Cccccc.airbnb.domain.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ReviewCreateDto {
    private Integer userId;
    private Integer roomId;
    private Integer cleanliness;
    private Integer accuracy;
    private Integer checkin;
    private Integer communication;
    private Integer location;
    private Integer value;
    private String content;
    private LocalDateTime creationDate;

    public Review convertTo(User user, Room room) {
        return new Review(
                null,
                user,
                room,
                cleanliness,
                accuracy,
                checkin,
                communication,
                location,
                value,
                content,
                creationDate != null ? creationDate : LocalDateTime.now()
        );
    }
}
