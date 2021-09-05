package com.example.movieratings.services;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.model.Movie;
import com.example.movieratings.model.Review;
import com.example.movieratings.repositories.MovieRepository;
import com.example.movieratings.repositories.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;

class ReviewServiceUnitTests extends AbstractTestClass {

    @Mock
    MovieRepository movieRepository;
    @Mock
    ReviewRepository reviewRepository;

    @InjectMocks
    ReviewService service;


    @Test
    void deleteReviewSuccessfulTest() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.of(createTestReview()));

        service.deleteReview(1L);

        verify(reviewRepository, times(1)).findById(1L);
        verify(reviewRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteReviewNoResultTest() {
        when(reviewRepository.findById(1L)).thenReturn(Optional.empty());

        service.deleteReview(1L);

        verify(reviewRepository, times(1)).findById(1L);
        verify(reviewRepository, times(0)).deleteById(1L);
    }

    @Test
    void createNewReviewForExistingMovieTest() {
        when(movieRepository.findOneById(1L)).thenReturn(Optional.of(createTestMovie()));

        service.createNewReview(createReviewDto(), 1L);

        verify(movieRepository, times(1)).findOneById(1L);
        verify(reviewRepository, times(1)).save(any());
    }

    @Test
    void createNewReviewForNotExistingMovieTest() {
        when(movieRepository.findOneById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.createNewReview(createReviewDto(), 1L)).hasMessageContaining("id: 1");

        verify(movieRepository, times(1)).findOneById(1L);
        verifyNoInteractions(reviewRepository);
    }

}
