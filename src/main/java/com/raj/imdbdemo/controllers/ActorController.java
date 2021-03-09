package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.ActorDTO;
import com.raj.imdbdemo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public Object getAllActors(Model model) {
        return actorService.getAllActors();
    }

    @GetMapping("/actor/{id}")
    public Object editActor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("actor",actorService.getActorById(id));
        return actorService.getActorById(id);
    }

    @PutMapping("/actor")
    public String updateActor(@RequestBody ActorDTO actor) {
        actorService.updateActor(actor);
        return "Updated";
    }
}
