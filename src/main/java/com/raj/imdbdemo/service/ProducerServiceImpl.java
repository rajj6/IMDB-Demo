package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.ProducerDTO;
import com.raj.imdbdemo.entity.Producer;
import com.raj.imdbdemo.repo.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ProducerDTO getProducerById(long id) {
        return ProducerDTO.mapEntityToDTO(producerRepository.getOne(id));
    }

    @Override
    public void updateProducer(ProducerDTO producerDTO) {
        Producer producer = producerRepository.getOne(producerDTO.getId());
        producer.setName(producerDTO.getName());
        producer.setSex(producerDTO.getSex());
        producer.setDOB(producerDTO.getDOB());
        producer.setBio(producerDTO.getBio());
        producerRepository.save(producer);
    }
}
