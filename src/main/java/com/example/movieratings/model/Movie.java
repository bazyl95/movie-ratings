package com.example.movieratings.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String director;
    private Date releaseDate;

    @OneToMany(mappedBy = "movie")
    private List<Review> reviews;

}