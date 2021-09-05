package com.example.movieratings.repositories;

import com.example.movieratings.dao.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findOneById(Long id);
    List<Movie> findAll();
    List<Movie> findByNameContainingIgnoreCase(String name);
}
