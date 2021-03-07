package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.ActorDTO;
import com.raj.imdbdemo.entity.Actor;
import com.raj.imdbdemo.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorRepository actorRepository;

    @Override
    public List<ActorDTO> getAllActors() {
        return ActorDTO.mapEntityToDTO(actorRepository.findAll());
    }

    @Override
    public ActorDTO getActorById(long id) {
        return ActorDTO.mapEntityToDTO(actorRepository.getOne(id));
    }

    @Override
    public void updateActor(ActorDTO actorDTO) {
        Actor actor =  actorRepository.getOne(actorDTO.getId());
        actor.setName(actorDTO.getName());
        actor.setSex(actorDTO.getSex());
        actor.setBio(actorDTO.getBio());
        actor.setDOB(actorDTO.getDOB());
        actorRepository.save(actor);
    }
}
