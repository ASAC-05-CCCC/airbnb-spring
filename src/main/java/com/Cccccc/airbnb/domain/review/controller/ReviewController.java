package com.Cccccc.airbnb.domain.review.controller;


import com.Cccccc.airbnb.domain.review.dto.ReviewResponseDto;
import com.Cccccc.airbnb.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/c2/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService ReviewService;

    @GetMapping("/{id}")
    public List<ReviewResponseDto> getReviewByRoomId(@PathVariable Integer id){
        return ReviewService.getReviewByRoomId(id);
    }
}
