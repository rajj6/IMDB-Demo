package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/actors")
    public String getAllActors(Model model) {
        model.addAttribute("actors", actorService.getAllActors());
        return "actors";
    }
}
