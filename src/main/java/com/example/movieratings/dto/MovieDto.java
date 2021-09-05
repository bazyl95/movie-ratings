package com.example.movieratings.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovieDto {

    private Long id;
    private String name;
    private String director;
    private String releaseDate;
    private List<ReviewDto> reviews;

}
