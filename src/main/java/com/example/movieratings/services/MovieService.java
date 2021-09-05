package com.example.movieratings.services;

import com.example.movieratings.dto.MovieDto;
import com.example.movieratings.exceptions.MovieNotFoundException;
import com.example.movieratings.repositories.MovieRepository;
import com.example.movieratings.util.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper mapper;

    @Autowired
    MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        mapper = new MovieMapper();
    }

    public MovieDto findMovieById(Long id) {
        return mapper.mapToDto(movieRepository.findOneById(id)
                .orElseThrow(() -> new MovieNotFoundException(id.toString())));
    }

    public List<MovieDto> findAllMovies() {
        return mapper.mapToDtoList(movieRepository.findAll());
    }

    public List<MovieDto> findAllMoviesByName(String name) {
        return mapper.mapToDtoList(movieRepository.findByNameContainingIgnoreCase(name));
    }
}
