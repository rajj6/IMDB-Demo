package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.service.ActorService;
import com.raj.imdbdemo.service.MovieService;
import com.raj.imdbdemo.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class TestRestController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private ActorService actorService;

    @Autowired
    private ProducerService producerService;

    @GetMapping("/test")
    public Object test() {
        return movieService.getAllMovies();
    }

    @PostMapping("/test")
    public Object test1(@RequestParam("poster")MultipartFile poster) {
        System.out.println(poster.getOriginalFilename());
        System.out.println(poster.getContentType());
        System.out.println(poster.getName());
        System.out.println(poster.isEmpty());
        System.out.println(poster.getSize());
        return poster;
    }
}