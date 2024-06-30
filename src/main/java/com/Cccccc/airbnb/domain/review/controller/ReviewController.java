package com.Cccccc.airbnb.domain.review.controller;

import com.Cccccc.airbnb.domain.review.dto.ReviewCreateDto;
import com.Cccccc.airbnb.domain.review.dto.ReviewResponseDto;
import com.Cccccc.airbnb.domain.review.dto.ReviewUpdateDto;
import com.Cccccc.airbnb.domain.review.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/c2/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping("/{id}")
    public List<ReviewResponseDto> getReviewByRoomId(@PathVariable Integer id) {
        return reviewService.getReviewByRoomId(id);
    }

    @PostMapping("/add")
    public ReviewResponseDto create(@RequestBody ReviewCreateDto request) {
        return reviewService.create(request);
    }

    @PatchMapping("/{id}/fix")
    public ReviewResponseDto update(@PathVariable Integer id, @RequestBody ReviewUpdateDto request) {
        return reviewService.update(id, request);
    }

    @DeleteMapping("/{id}/delete")
    public Integer delete(@PathVariable Integer id) {
        return reviewService.delete(id);
    }
}
