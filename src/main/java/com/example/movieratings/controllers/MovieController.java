package com.example.movieratings.controllers;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String returnAllMovies(Model model) {
        model.addAttribute("movies", movieService.findAllMovies());
        model.addAttribute("content", "movies");
        return "main";
    }

    @GetMapping("/{id}")
    public String getIndex(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.findMovieById(id));
        model.addAttribute("content", "browseMovie");
        model.addAttribute("newReview", new ReviewDto());
        return "main";
    }

    @GetMapping("/search")
    public String getIndex(@RequestParam String name, Model model) {
        model.addAttribute("movies", movieService.findAllMoviesByName(name));
        model.addAttribute("isMovieSearch", true);
        model.addAttribute("name", name);
        model.addAttribute("content", "searchMovies");
        return "main";
    }
}
