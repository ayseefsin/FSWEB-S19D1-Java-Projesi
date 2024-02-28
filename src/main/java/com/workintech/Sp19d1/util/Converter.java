package com.workintech.Sp19d1.util;

import com.workintech.Sp19d1.dto.ActorRequest;
import com.workintech.Sp19d1.dto.ActorResponse;
import com.workintech.Sp19d1.dto.MovieResponse;
import com.workintech.Sp19d1.entity.Actor;
import com.workintech.Sp19d1.entity.Movie;
import org.springframework.aop.support.annotation.AnnotationMethodMatcher;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<ActorResponse> actorResponseConvert(List<Actor> actorList){
        List<ActorResponse> actors = new ArrayList<>();
        for(Actor actor: actorList){
            actors.add(new ActorResponse(actor.getId(),actor.getFirstName(),actor.getLastName(),actor.getBirthDate(),null));
        }
        return actors;

    }
    public static ActorResponse actorResponseConvert(Actor actor){
        return new ActorResponse(actor.getId(),actor.getFirstName(),actor.getLastName(),actor.getBirthDate(),null);
    }

    public static ActorResponse actorCreateResponseCover(Actor actor){
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate(),actor.getMovieList());
    }

    public static List<MovieResponse> movieResponseConvert(List<Movie> movies){
        List<MovieResponse> movieResponseList=new ArrayList<>();
        for(Movie movie:movies){
            movieResponseList.add(new MovieResponse(movie.getId(), movie.getName(),null));
        }
        return movieResponseList;
    }
    public static MovieResponse movieResponseConvert(Movie movie){
        return new MovieResponse(movie.getId(),movie.getName(),null);
    }
}
