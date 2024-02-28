package com.workintech.Sp19d1.repository;

import com.workintech.Sp19d1.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
