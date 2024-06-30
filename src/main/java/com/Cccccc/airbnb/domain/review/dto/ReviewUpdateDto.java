package com.Cccccc.airbnb.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewUpdateDto {
    private Integer cleanliness;
    private Integer accuracy;
    private Integer checkin;
    private Integer communication;
    private Integer location;
    private Integer value;
    private String content;
}
