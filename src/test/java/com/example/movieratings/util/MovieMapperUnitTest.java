package com.example.movieratings.util;

import com.example.movieratings.dto.MovieDto;
import com.example.movieratings.services.AbstractTestClass;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MovieMapperUnitTest extends AbstractTestClass {

    @Test
    void mapToDtoTest() {
        MovieDto testDto = MovieMapper.mapToDto(createTestMovie());
        assertThat(testDto.getId()).isEqualTo(1L);
        assertThat(testDto.getName()).isEqualTo("Test movie name");
        assertThat(testDto.getDirector()).isEqualTo("Test director");
        assertThat(testDto.getReviews()).isNotNull();
        assertThat(testDto.getReviews().isEmpty()).isTrue();
    }

    @Test
    void mapToDtoListTest() {
        List<MovieDto> testDto = MovieMapper.mapToDtoList(createTestMovies());
        assertThat(testDto)
                .isNotNull()
                .hasSize(2);
        assertThat(testDto.get(0).getId()).isEqualTo(1L);
        assertThat(testDto.get(1).getId()).isEqualTo(2L);

    }
}
