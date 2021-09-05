package com.example.movieratings.util;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.model.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewMapper {
    private ReviewMapper() {    }
    public static ReviewDto mapToDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setText(review.getText());
        dto.setMark(review.getMark());
        return dto;
    }

    public static List<ReviewDto> mapToDtoList(List<Review> movies) {
        return movies.stream()
                .map(ReviewMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public static Review mapToReview(ReviewDto dto) {
        Review review = new Review();
        review.setMark(dto.getMark());
        review.setText(dto.getText());
        return review;
    }
}
