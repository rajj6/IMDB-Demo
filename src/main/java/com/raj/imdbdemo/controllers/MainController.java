package com.raj.imdbdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @GetMapping({"/home", "/"})
    public String home(Model model) {
        return "redirect:/movies";
    }
}