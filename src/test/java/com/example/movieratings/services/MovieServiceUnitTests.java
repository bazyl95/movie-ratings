package com.example.movieratings.services;

import com.example.movieratings.dto.MovieDto;
import com.example.movieratings.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class MovieServiceUnitTests extends AbstractTestClass {

    @Mock
    MovieRepository repository;
    @InjectMocks
    MovieService service;


    @Test
    void findMovieByIdSuccessfulResultTest() {
        when(repository.findOneById(1L)).thenReturn(Optional.of(createTestMovie()));

        MovieDto foundMovie = service.findMovieById(1L);

        assertThat(foundMovie).isNotNull();
    }

    @Test
    void findMovieByIdNoResultTest() {
        when(repository.findOneById(1L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> service.findMovieById(1L)).hasMessageContaining("id: 1");
    }

    @Test
    void findAllMoviesSuccessfulResultTest() {
        when(repository.findAll()).thenReturn(createTestMovies());

        List<MovieDto> foundMovies = service.findAllMovies();

        assertThat(foundMovies)
                .isNotNull()
                .hasSize(2);
    }

    @Test
    void findAllMoviesNoResultTest() {
        when(repository.findAll()).thenReturn(new ArrayList<>());

        List<MovieDto> foundMovies = service.findAllMovies();

        assertThat(foundMovies).isEmpty();
    }

    @Test
    void findAllMoviesByNameSuccessfulResultTest() {
        when(repository.findByNameContainingIgnoreCase("test")).thenReturn(createTestMovies());

        List<MovieDto> foundMovies = service.findAllMoviesByName("test");

        assertThat(foundMovies)
                .isNotNull()
                .hasSize(2);
    }

    @Test
    void findAllMoviesByNameNoResultTest() {
        when(repository.findByNameContainingIgnoreCase("testNoResults")).thenReturn(new ArrayList<>());

        List<MovieDto> foundMovies = service.findAllMoviesByName("testNoResults");

        assertThat(foundMovies).isEmpty();
    }
}
