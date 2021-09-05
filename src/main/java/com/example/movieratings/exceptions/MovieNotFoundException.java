package com.example.movieratings.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String id) {
        super("Movie not found with id: " + id);
    }

    public MovieNotFoundException(String id, Exception e) {
        super("Movie not found with id: " + id, e);
    }
}
