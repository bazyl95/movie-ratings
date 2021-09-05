package com.example.movieratings.controllers;

import com.example.movieratings.dto.ReviewDto;
import com.example.movieratings.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("newReview", new ReviewDto());
        model.addAttribute("content", "browseMovie");
        return "main";
    }

    @GetMapping("/search")
    public String getIndex(@RequestParam String name, Model model) {
        model.addAttribute("movies", movieService.findAllMoviesByName(name));
        model.addAttribute("name", name);
        model.addAttribute("content", "searchMovies");
        return "main";
    }
}
