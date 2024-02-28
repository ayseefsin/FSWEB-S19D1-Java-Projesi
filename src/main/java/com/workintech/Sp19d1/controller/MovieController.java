package com.workintech.Sp19d1.controller;

import com.workintech.Sp19d1.dto.MovieRequest;
import com.workintech.Sp19d1.dto.MovieResponse;
import com.workintech.Sp19d1.entity.Actor;
import com.workintech.Sp19d1.entity.Movie;
import com.workintech.Sp19d1.repository.MovieRepository;
import com.workintech.Sp19d1.service.MovieService;
import com.workintech.Sp19d1.service.MovieServiceImpl;
import com.workintech.Sp19d1.util.Converter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.servlet.mvc.method.annotation.ModelAndViewResolverMethodReturnValueHandler;

import java.util.ArrayList;
import java.util.List;

@RestController
@Data
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public MovieResponse save(@RequestBody MovieRequest movieRequest){
       List<Actor> actors= movieRequest.getActors();
       Movie movie = movieRequest.getMovie();
        for(Actor actor:actors){
            movie.addActor(actor);
        }
        movieService.addNewMovie(movie);
        return Converter.movieResponseConvert(movie);

    }

    @GetMapping
    public List<MovieResponse> getAllMovies(){
      List<Movie> movieList=  movieService.getAllMovies();

      return Converter.movieResponseConvert(movieList);
    }

    @GetMapping("/{id}")
    public MovieResponse getMovieById(@PathVariable long id){
        return Converter.movieResponseConvert(movieService.getMovieById(id));
    }

    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie,@PathVariable long id){
        movieService.getMovieById(id);
        movie.setActorList(movie.getActorList());
        movie.setId(id);
        movieService.addNewMovie(movie);
        return Converter.movieResponseConvert(movie);
    }
    @DeleteMapping("/{id}")
    public MovieResponse delete(@PathVariable long id){
        Movie deleted=movieService.getMovieById(id);
        movieService.deleteMovie(movieService.getMovieById(id));
        return Converter.movieResponseConvert(deleted);
    }
}
