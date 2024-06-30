package com.Cccccc.airbnb.domain.review.service;

import com.Cccccc.airbnb.domain.entity.Review;
import com.Cccccc.airbnb.domain.entity.Room;
import com.Cccccc.airbnb.domain.entity.User;
import com.Cccccc.airbnb.domain.review.common.CustomException;
import com.Cccccc.airbnb.domain.review.common.ExceptionType;
import com.Cccccc.airbnb.domain.review.dto.ReviewCreateDto;
import com.Cccccc.airbnb.domain.review.dto.ReviewResponseDto;
import com.Cccccc.airbnb.domain.review.dto.ReviewUpdateDto;
import com.Cccccc.airbnb.domain.review.repository.ReviewRepository;
import com.Cccccc.airbnb.domain.review.util.RatingUtils;
import com.Cccccc.airbnb.domain.room.repository.RoomRepository;
import com.Cccccc.airbnb.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public List<ReviewResponseDto> getReviewByRoomId(Integer roomId) {
        List<Review> reviews = reviewRepository.findByRoomId(roomId);
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

    public ReviewResponseDto create(ReviewCreateDto request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException(ExceptionType.NOT_EXIST, "유저 정보가 존재하지 않습니다 - id : " + request.getUserId()));
        Room room = roomRepository.findById(request.getRoomId())
                .orElseThrow(() -> new CustomException(ExceptionType.NOT_EXIST, "룸 정보가 존재하지 않습니다 - id : " + request.getRoomId()));

        Review review = request.convertTo(user, room);
        Review created = reviewRepository.save(review);
        return ReviewResponseDto.of(created);
    }

    public ReviewResponseDto update(int id, ReviewUpdateDto request) {
        Review retrieved = reviewRepository.findById(id)
                .orElseThrow(() -> new CustomException(ExceptionType.NOT_EXIST, "리뷰 정보가 존재하지 않습니다 - id : " + id));
        retrieved.updateContent(request.getCleanliness(), request.getAccuracy(), request.getCheckin(), request.getCommunication(), request.getLocation(), request.getValue(), request.getContent());
        Review updated = reviewRepository.save(retrieved);
        return ReviewResponseDto.of(updated);
    }

    public int delete(int id) {
        reviewRepository.deleteById(id);
        return id;
    }
}
