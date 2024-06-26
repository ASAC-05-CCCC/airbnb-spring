package com.Cccccc.airbnb.domain.review.util;

import com.Cccccc.airbnb.domain.entity.Review;

public class RatingUtils {
    public static int calculateAverageRating(Review review) {
        int totalRating = 0;
        int numberOfRatings = 6; // 평가 항목의 개수

        totalRating += review.getCleanliness();
        totalRating += review.getAccuracy();
        totalRating += review.getCheckin();
        totalRating += review.getCommunication();
        totalRating += review.getLocation();
        totalRating += review.getValue();

        return totalRating / numberOfRatings;
    }
}
