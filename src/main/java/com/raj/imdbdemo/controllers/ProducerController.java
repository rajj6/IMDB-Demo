package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.ProducerDTO;
import com.raj.imdbdemo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProducerController {
    @Autowired
    ProducerService producerService;

    @GetMapping("/producers")
    public String getAllActors(Model model) {
        model.addAttribute("producers", producerService.getAllProducer());
        return "producers";
    }

    @GetMapping("/editProducer/{id}")
    public String editActor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("producer", producerService.getProducerById(id));
        return "edit_producer_form";
    }

    @PostMapping("/updateProducer")
    public String updateActor(@ModelAttribute("actor") ProducerDTO producer) {
        producerService.updateProducer(producer);
        return "redirect:/producers";
    }
}
