package com.example.movieratings.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private Long id;
    private String text;
    private int mark;
}
