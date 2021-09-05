package com.example.movieratings.dao;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String text;
    private int mark;

    @ManyToOne
    private Movie movie;
}
