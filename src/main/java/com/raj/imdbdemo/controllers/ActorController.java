package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.ActorDTO;
import com.raj.imdbdemo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public String getAllActors(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "actors";
    }

    @GetMapping("/editActor/{id}")
    public String editActor(@PathVariable("id") Long id, Model model) {
        model.addAttribute("actor",actorService.getActorById(id));
        return "edit_actor_form";
    }

    @PostMapping("/updateActor")
    public String updateActor(@ModelAttribute("actor")ActorDTO actor) {
        actorService.updateActor(actor);
        return "redirect:/actors";
    }
}
