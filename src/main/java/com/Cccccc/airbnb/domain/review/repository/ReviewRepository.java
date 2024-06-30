package com.Cccccc.airbnb.domain.review.repository;

import com.Cccccc.airbnb.domain.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByRoomId(Integer id);
    Review save(Review entity);
    void deleteById(Integer integer);
}
