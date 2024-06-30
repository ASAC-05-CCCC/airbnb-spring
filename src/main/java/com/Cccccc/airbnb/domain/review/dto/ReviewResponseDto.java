package com.Cccccc.airbnb.domain.review.dto;

import com.Cccccc.airbnb.domain.entity.Review;
import com.Cccccc.airbnb.domain.review.util.RatingUtils;
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

    public static ReviewResponseDto of(Review review) {
        int averageRating = RatingUtils.calculateAverageRating(review);
        return new ReviewResponseDto(
                review.getRoom().getId(),
                review.getUser().getName(),
                review.getUser().getImage(),
                averageRating,
                review.getCreation_date(),
                review.getContent()
        );
    }
}
