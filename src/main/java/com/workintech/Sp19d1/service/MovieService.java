package com.workintech.Sp19d1.service;

import com.workintech.Sp19d1.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

    Movie getMovieById(Long id);

    Movie addNewMovie(Movie movie);

    void deleteMovie(Movie movie);

}
