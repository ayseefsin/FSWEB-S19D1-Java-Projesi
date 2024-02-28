package com.workintech.Sp19d1.controller;

import com.workintech.Sp19d1.dto.ActorRequest;
import com.workintech.Sp19d1.dto.ActorResponse;
import com.workintech.Sp19d1.entity.Actor;
import com.workintech.Sp19d1.entity.Movie;
import com.workintech.Sp19d1.service.ActorService;
import com.workintech.Sp19d1.util.Converter;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<ActorResponse> getAllActors(){
        List<Actor> actors = new ArrayList<>();
        return Converter.actorResponseConvert(actors);
    }
    @GetMapping("/{id}")
    public ActorResponse getActorById(@PathVariable long id ){

        return Converter.actorResponseConvert(actorService.getActorById(id));
    }

    @PostMapping
    public ActorResponse save(@Validated @RequestBody ActorRequest actorRequest){
        List<Movie> movies = actorRequest.getMovieList();
        Actor actor = actorRequest.getActor();
        for(Movie movie : movies){
            actor.addMovie(movie);
        }
        actorService.addNewActor(actor);
        return Converter.actorCreateResponseCover(actor);
    }
    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor , @PathVariable Long id){
        Actor foundActor = actorService.getActorById(id);
        actor.setMovieList(foundActor.getMovieList());
        actor.setId(id);
        actorService.addNewActor(actor); //can change
        return Converter.actorResponseConvert(actor);
    }
    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable long id){
        Actor foundActor = actorService.getActorById(id);
        actorService.deleteActor(foundActor);
        return Converter.actorResponseConvert(foundActor) ;
    }

}
