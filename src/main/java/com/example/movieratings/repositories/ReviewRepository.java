package com.example.movieratings.repositories;

import com.example.movieratings.dao.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
