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

    MovieRepository movieRepository;

    @Autowired
    MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieDto findMovieById(Long id) {
        return MovieMapper.mapToDto(movieRepository.findOneById(id)
                .orElseThrow(() -> new MovieNotFoundException(id.toString())));
    }

    public List<MovieDto> findAllMovies() {
        return MovieMapper.mapToDtoList(movieRepository.findAll());
    }

    public List<MovieDto> findAllMoviesByName(String name) {
        return MovieMapper.mapToDtoList(movieRepository.findByNameContainingIgnoreCase(name));
    }
}
