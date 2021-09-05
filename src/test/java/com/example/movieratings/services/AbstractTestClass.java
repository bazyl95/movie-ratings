package com.example.movieratings.services;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.model.Movie;
import com.example.movieratings.model.Review;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public abstract class AbstractTestClass {

    protected Movie createTestMovie() {
        Movie testMovie = new Movie();
        testMovie.setId(1L);
        testMovie.setName("Test movie name");
        testMovie.setDirector("Test director");
        testMovie.setReleaseDate(new Date());
        testMovie.setReviews(new ArrayList<>());
        return testMovie;
    }

    protected List<Movie> createTestMovies() {
        Movie testMovie1 = createTestMovie();
        Movie testMovie2 = createTestMovie();
        testMovie2.setId(2L);

        return Arrays.asList(testMovie1, testMovie2);
    }

    protected Review createTestReview() {
        Review testReview = new Review();
        testReview.setId(1L);
        testReview.setMark(10);
        testReview.setText("Test text");
        testReview.setMovie(new Movie());
        return testReview;
    }

    protected ReviewDto createReviewDto() {
        ReviewDto testDto = new ReviewDto();
        testDto.setId(1L);
        testDto.setMark(10);
        testDto.setText("Some test text");
        return testDto;
    }
}
