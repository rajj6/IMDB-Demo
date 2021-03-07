package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.ActorDTO;

import java.util.List;

public interface ActorService {
    List<ActorDTO> getAllActors();
    ActorDTO getActorById(long id);
    void updateActor(ActorDTO actorDTO);
}
