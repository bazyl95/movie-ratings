package com.example.movieratings;

import com.example.movieratings.model.Movie;
import com.example.movieratings.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MovieRepositoryIntegrationTests {

    @Autowired
    MovieRepository movieRepository;

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Test
    void findOneByIdMovieRepositorySuccessfulTest() {
        Optional<Movie> foundMovie = movieRepository.findOneById(1L);

        assertThat(foundMovie).isPresent();
        assertThat(foundMovie.get().getId()).isEqualTo(1L);
        assertThat(foundMovie.get().getName()).isEqualTo("Lords of the Rings");
        assertThat(foundMovie.get().getDirector()).isEqualTo("Peter Jackson");
        assertThat(dateFormat.format(foundMovie.get().getReleaseDate())).isEqualTo("19-12-2001");
    }

    @Test
    void findOneByIdMovieRepositoryNotFoundTest() {
        Optional<Movie> foundMovie = movieRepository.findOneById(1000L);

        assertThat(foundMovie).isNotPresent();
    }

    @Test
    void findAllMovieRepositoryTest() {
        List<Movie> foundMovies = movieRepository.findAll();

        assertThat(foundMovies)
                .isNotNull()
                .isNotEmpty()
                .hasSize(6);
    }

    @Test
    void findByNameContainingIgnoreCaseMovieRepositorySuccessfulTest() {
        List<Movie> foundMovies = movieRepository.findByNameContainingIgnoreCase("doom");

        assertThat(foundMovies)
                .isNotNull()
                .isNotEmpty()
                .hasSize(1);
        Movie foundResult = foundMovies.get(0);
        assertThat(foundResult).isNotNull();
        assertThat(foundResult.getId()).isEqualTo(6L);
        assertThat(foundResult.getName()).isEqualTo("Doom");
        assertThat(foundResult.getDirector()).isEqualTo("Andrzej Bartkowiak");
    }

    @Test
    void findByNameContainingIgnoreCaseMovieRepositoryEmptyResultTest() {
        List<Movie> foundMovies = movieRepository.findByNameContainingIgnoreCase("this does not exist");

        assertThat(foundMovies)
                .isNotNull()
                .isEmpty();
    }
}
