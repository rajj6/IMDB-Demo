package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.ProducerDTO;
import com.raj.imdbdemo.entity.Producer;
import com.raj.imdbdemo.repo.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService{
    @Autowired
    ProducerRepository producerRepository;
    @Override
    public List<ProducerDTO> getAllProducer() {
        return ProducerDTO.mapEntityToDTO(producerRepository.findAll());
    }

    @Override
    @Cacheable(value = "producerDTO", key = "#id")
    public ProducerDTO getProducerById(long id) {
        return ProducerDTO.mapEntityToDTO(producerRepository.getOne(id));
    }

    @Override
    @CachePut(value = "producerDTO", key = "#producerDTO.id")
    public ProducerDTO updateProducer(ProducerDTO producerDTO) {
        Producer producer = producerRepository.getOne(producerDTO.getId());
        producer.setName(producerDTO.getName());
        producer.setSex(producerDTO.getSex());
        producer.setDOB(producerDTO.getDOB());
        producer.setBio(producerDTO.getBio());
        Producer producerSaved =  producerRepository.save(producer);
        return ProducerDTO.mapEntityToDTO(producerSaved);
    }
}
