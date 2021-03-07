package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.ActorDTO;
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
}
