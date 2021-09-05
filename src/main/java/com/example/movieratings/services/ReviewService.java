package com.example.movieratings.services;

import com.example.movieratings.dao.Movie;
import com.example.movieratings.dao.Review;
import com.example.movieratings.dto.ReviewDto;
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
                .orElseThrow(() -> new IllegalArgumentException("There isn't movie with id: " + movieId));
        reviewToSave.setMovie(movie);
        reviewRepository.save(reviewToSave);
//        Movie movie = movieRepository.findOneById(movieId)
//                .orElseThrow(() -> new IllegalArgumentException("There isn't movie with id: " + movieId));
//        movie.getReviews().add(ReviewMapper.mapToReview(dto));
//        movieRepository.save(movie);
    }
}
