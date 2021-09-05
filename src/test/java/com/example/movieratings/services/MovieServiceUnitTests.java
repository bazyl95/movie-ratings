package com.example.movieratings.services;

import com.example.movieratings.dto.MovieDto;
import com.example.movieratings.model.Movie;
import com.example.movieratings.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceUnitTests {

    @Mock
    MovieRepository repository;
    @InjectMocks
    MovieService service;

    private Movie createTestMovie() {
        Movie testMovie = new Movie();
        testMovie.setId(1L);
        testMovie.setName("Test movie name");
        testMovie.setDirector("Test director");
        testMovie.setReleaseDate(new Date());
        testMovie.setReviews(new ArrayList<>());
        return testMovie;
    }

    private List<Movie> createTestMovies() {
        Movie testMovie1 = createTestMovie();
        Movie testMovie2 = createTestMovie();
        testMovie2.setId(2L);

        return Arrays.asList(testMovie1, testMovie2);
    }

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
