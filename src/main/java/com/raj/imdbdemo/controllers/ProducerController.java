package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.ProducerDTO;
import com.raj.imdbdemo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @GetMapping("/producers")
    public String getAllProducer(Model model) {
        model.addAttribute("producers", producerService.getAllProducer());
        return "producers";
    }

    @GetMapping("/producer/{id}")
    public String editProducer(@PathVariable("id") Long id, Model model) {
        model.addAttribute("producer", producerService.getProducerById(id));
        return "edit_producer_form";
    }

    @PostMapping("/producer")
    public String updateProducer(@ModelAttribute("actor") ProducerDTO producer) {
        producerService.updateProducer(producer);
        return "redirect:/producers";
    }
}
