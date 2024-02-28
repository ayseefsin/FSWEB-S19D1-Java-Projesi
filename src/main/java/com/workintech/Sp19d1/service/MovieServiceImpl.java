package com.workintech.Sp19d1.service;

import com.workintech.Sp19d1.entity.Movie;
import com.workintech.Sp19d1.exception.ApiException;
import com.workintech.Sp19d1.repository.MovieRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Data
public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override// can change
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(()->
                new ApiException("invalid id" , HttpStatus.NOT_FOUND));
    }
    @Override
    public Movie addNewMovie(Movie movie) {
        return movieRepository.save(movie);
    }
    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}
