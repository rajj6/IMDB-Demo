package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.ActorDTO;
import com.raj.imdbdemo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public String getAllActors(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "actors";
    }

    @GetMapping("/actor/{id}")
    public String editActor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("actor",actorService.getActorById(id));
        return "edit_actor_form";
    }

    @PutMapping("/actor")
    public String updateActor(@ModelAttribute("actor")ActorDTO actor) {
        actorService.updateActor(actor);
        return "redirect:/actors";
    }
}
