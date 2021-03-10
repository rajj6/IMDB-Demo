package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.ActorDTO;
import com.raj.imdbdemo.entity.Actor;
import com.raj.imdbdemo.repo.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "actorDTO", key = "#id")
    public ActorDTO getActorById(long id) {
        return ActorDTO.mapEntityToDTO(actorRepository.getOne(id));
    }

    @Override
    @CachePut(value = "actorDTO", key = "#actorDTO.id")
    public ActorDTO updateActor(ActorDTO actorDTO) {
        System.out.println(actorDTO);
        Actor actor =  actorRepository.getOne(actorDTO.getId());
        actor.setName(actorDTO.getName());
        actor.setSex(actorDTO.getSex());
        actor.setBio(actorDTO.getBio());
        actor.setDOB(actorDTO.getDOB());
        System.out.println(actor);
        Actor actorSaved = actorRepository.save(actor);
        return ActorDTO.mapEntityToDTO(actorSaved);
    }
}
