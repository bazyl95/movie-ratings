package com.example.movieratings.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MovieExceptionHandler {

    @ExceptionHandler({MovieNotFoundException.class})
    public final String respondWithErrorPage(MovieNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        model.addAttribute("content", "error");
        return "main";
    }
}
