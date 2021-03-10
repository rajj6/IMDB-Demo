package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    MovieService movieService;

    @GetMapping({"/home", "/"})
    public String home(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "home";
    }
}