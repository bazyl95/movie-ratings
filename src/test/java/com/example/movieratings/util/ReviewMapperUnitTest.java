package com.example.movieratings.util;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.model.Review;
import com.example.movieratings.services.AbstractTestClass;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReviewMapperUnitTest extends AbstractTestClass {

    @Test
    void mapToDtoTest() {
        ReviewDto testDto = ReviewMapper.mapToDto(createTestReview());
        assertThat(testDto.getId()).isEqualTo(1L);
        assertThat(testDto.getText()).isEqualTo("Test text");
        assertThat(testDto.getMark()).isEqualTo(10);
    }

    @Test
    void mapToDtoListTest() {
        List<Review> testReviews = Arrays.asList(createTestReview(), createTestReview());
        List<ReviewDto> testDto = ReviewMapper.mapToDtoList(testReviews);
        assertThat(testDto).isNotNull();
        assertThat(testDto.size()).isEqualTo(2);
        assertThat(testDto.get(0).getId()).isEqualTo(1L);
        assertThat(testDto.get(0).getText()).isEqualTo("Test text");
        assertThat(testDto.get(0).getMark()).isEqualTo(10);
    }

    @Test
    void mapToReviewTest() {
        Review testReview = ReviewMapper.mapToReview(createReviewDto());
        assertThat(testReview.getId()).isNull();
        assertThat(testReview.getText()).isEqualTo("Some test text");
        assertThat(testReview.getMark()).isEqualTo(10);
        assertThat(testReview.getMovie()).isNull();
    }
}
