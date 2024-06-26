package com.Cccccc.airbnb.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ReviewResponseDto {
    private Integer post_id;
    private String name;
    private String image;
    private Integer rating;
    private LocalDateTime timestamp;
    private String message;
}
