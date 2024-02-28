package com.workintech.Sp19d1.dto;

import com.workintech.Sp19d1.entity.Actor;
import com.workintech.Sp19d1.entity.Movie;
import lombok.Data;

import java.util.List;

@Data
public class ActorRequest {
    private List<Movie> movieList;
    private Actor actor;
}
