package com.example.movieratings;

import com.example.movieratings.model.Movie;
import com.example.movieratings.model.Review;
import com.example.movieratings.repositories.ReviewRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ReviewRepositoryIntegrationTests {

    @Autowired
    ReviewRepository reviewRepository;


    @BeforeEach
    void persistReview() {
        Review testReview = new Review();
        testReview.setText("test review");
        testReview.setMark(5);
        Movie testMovie = new Movie();
        testMovie.setId(1L);
        testReview.setMovie(testMovie);
        reviewRepository.save(testReview);
    }

    @AfterEach
    void deleteReview() {
        reviewRepository.deleteById(1L);
    }

    @Test
    void findByIdReviewRepositorySuccessfulTest() {
        Optional<Review> foundReview = reviewRepository.findById(1L);
        assertThat(foundReview.isPresent()).isTrue();
        assertThat(foundReview.get().getMark()).isEqualTo(5);
        assertThat(foundReview.get().getText()).isEqualTo("test review");
    }

    @Test
    void findByIdReviewRepositoryNotFoundTest() {
        Optional<Review> foundReview = reviewRepository.findById(1000L);
        assertThat(foundReview.isPresent()).isFalse();
    }
}