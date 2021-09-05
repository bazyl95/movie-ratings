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
    private static final String CONTENT_FRAGMENT = "content";

    @Autowired
    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public String returnAllMovies(Model model) {
        model.addAttribute("movies", movieService.findAllMovies());
        model.addAttribute(CONTENT_FRAGMENT, "movies");
        return "main";
    }

    @GetMapping("/{id}")
    public String browseMovie(@PathVariable Long id, Model model) {
        model.addAttribute("movie", movieService.findMovieById(id));
        model.addAttribute("newReview", new ReviewDto());
        model.addAttribute(CONTENT_FRAGMENT, "browseMovie");
        return "main";
    }

    @GetMapping("/search")
    public String searchMovies(@RequestParam String name, Model model) {
        model.addAttribute("movies", movieService.findAllMoviesByName(name));
        model.addAttribute("name", name);
        model.addAttribute(CONTENT_FRAGMENT, "searchMovies");
        return "main";
    }
}
