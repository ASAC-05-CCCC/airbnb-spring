package com.Cccccc.airbnb.domain.review.service;

import com.Cccccc.airbnb.domain.entity.Review;
import com.Cccccc.airbnb.domain.review.dto.ReviewResponseDto;
import com.Cccccc.airbnb.domain.review.repository.ReviewRepository;
import com.Cccccc.airbnb.domain.review.util.RatingUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository ReviewRepository;

    public List<ReviewResponseDto> getReviewByRoomId(Integer roomId){
        List<Review> reviews = ReviewRepository.findByRoomId(roomId);
        return reviews.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ReviewResponseDto convertToDto(Review review) {
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
