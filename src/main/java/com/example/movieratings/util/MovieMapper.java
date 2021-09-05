package com.example.movieratings.util;

import com.example.movieratings.dto.MovieDto;
import com.example.movieratings.model.Movie;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private final ReviewMapper mapper = new ReviewMapper();

    public MovieDto mapToDto(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setName(movie.getName());
        dto.setDirector(movie.getDirector());
        dto.setReleaseDate(dateFormat.format(movie.getReleaseDate()));
        dto.setReviews(mapper.mapToDtoList(movie.getReviews()));
        return dto;
    }

    public List<MovieDto> mapToDtoList(List<Movie> movies) {
        return movies.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }
}
