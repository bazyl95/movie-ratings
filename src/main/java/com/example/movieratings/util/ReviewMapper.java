package com.example.movieratings.util;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.model.Review;

import java.util.List;
import java.util.stream.Collectors;

public class ReviewMapper {

    public ReviewDto mapToDto(Review review) {
        ReviewDto dto = new ReviewDto();
        dto.setId(review.getId());
        dto.setText(review.getText());
        dto.setMark(review.getMark());
        return dto;
    }

    public List<ReviewDto> mapToDtoList(List<Review> movies) {
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Review mapToReview(ReviewDto dto) {
        Review review = new Review();
        review.setMark(dto.getMark());
        review.setText(dto.getText());
        return review;
    }
}
