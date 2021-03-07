package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.ProducerDTO;

import java.util.List;

public interface ProducerService {
    List<ProducerDTO> getAllProducer();
    ProducerDTO getProducerById(long id);
    void updateProducer(ProducerDTO producerDTO);
}
