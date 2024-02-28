package com.workintech.Sp19d1.service;

import com.workintech.Sp19d1.entity.Actor;
import com.workintech.Sp19d1.exception.ApiException;
import com.workintech.Sp19d1.repository.ActorRepository;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;
    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override //can change
    public Actor getActorById(Long id) {
        return actorRepository.findById(id).orElseThrow(()->
                new ApiException("invalid id", HttpStatus.NOT_FOUND));
    }

    @Override
    public Actor addNewActor(Actor actor) {

        return actorRepository.save(actor);
    }

    @Override
    public void deleteActor(Actor actor) {
        actorRepository.delete(actor);
    }
}
