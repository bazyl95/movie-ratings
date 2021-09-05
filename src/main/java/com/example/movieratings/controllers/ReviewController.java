package com.example.movieratings.controllers;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.services.MovieService;
import com.example.movieratings.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/review")
public class ReviewController {

    private final MovieService movieService;
    private final ReviewService reviewService;

    @Autowired
    public ReviewController(MovieService movieService, ReviewService reviewService) {
        this.movieService = movieService;
        this.reviewService = reviewService;
    }

    @PostMapping("/{movieId}/delete/{id}")
    public RedirectView deleteReview(@PathVariable Long movieId, @PathVariable Long id) {
        reviewService.deleteReview(id);
        return new RedirectView("/movies/" + movieId);
    }

    @PostMapping("/{movieId}")
    public RedirectView createNewReview(@PathVariable Long movieId, @ModelAttribute ReviewDto reviewDto) {
        reviewService.createNewReview(reviewDto, movieId);
        return new RedirectView("/movies/" + movieId);
    }
}
