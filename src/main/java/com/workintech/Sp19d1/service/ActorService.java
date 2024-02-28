package com.workintech.Sp19d1.service;

import com.workintech.Sp19d1.entity.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> getAllActors();

    Actor getActorById(Long id);

    Actor addNewActor(Actor actor);

    void deleteActor(Actor actor);

}
