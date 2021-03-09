package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.ProducerDTO;
import com.raj.imdbdemo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProducerController {

    @Autowired
    ProducerService producerService;

    @GetMapping("/producers")
    public Object getAllProducer(Model model) {
        return producerService.getAllProducer();
    }

    @GetMapping("/producer/{id}")
    public Object editProducer(@PathVariable("id") Long id, Model model) {
        return producerService.getProducerById(id);
    }

    @PutMapping("/producer")
    public String updateProducer(@RequestBody ProducerDTO producer) {
        producerService.updateProducer(producer);
        return "Producer Updated";
    }
}