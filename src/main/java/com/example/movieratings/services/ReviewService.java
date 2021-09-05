package com.example.movieratings.services;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.exceptions.MovieNotFoundException;
import com.example.movieratings.model.Movie;
import com.example.movieratings.model.Review;
import com.example.movieratings.repositories.MovieRepository;
import com.example.movieratings.repositories.ReviewRepository;
import com.example.movieratings.util.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MovieRepository movieRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MovieRepository movieRepository) {
        this.reviewRepository = reviewRepository;
        this.movieRepository = movieRepository;
    }

    public void deleteReview(Long reviewId) {
        if (reviewRepository.findById(reviewId).isPresent()) {
            reviewRepository.deleteById(reviewId);
        }
    }

    public void createNewReview(ReviewDto dto, Long movieId) {
        Review reviewToSave = ReviewMapper.mapToReview(dto);
        Movie movie = movieRepository.findOneById(movieId)
                .orElseThrow(() -> new MovieNotFoundException(movieId.toString()));
        reviewToSave.setMovie(movie);
        reviewRepository.save(reviewToSave);
    }
}
