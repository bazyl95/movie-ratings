package com.example.movieratings.util;

import com.example.movieratings.dto.MovieDto;
import com.example.movieratings.model.Movie;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

public class MovieMapper {
    private MovieMapper() { }

    public static MovieDto mapToDto(Movie movie) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        MovieDto dto = new MovieDto();
        dto.setId(movie.getId());
        dto.setName(movie.getName());
        dto.setDirector(movie.getDirector());
        dto.setReleaseDate(dateFormat.format(movie.getReleaseDate()));
        dto.setReviews(ReviewMapper.mapToDtoList(movie.getReviews()));
        return dto;
    }

    public static List<MovieDto> mapToDtoList(List<Movie> movies) {
        return movies.stream()
                .map(MovieMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
