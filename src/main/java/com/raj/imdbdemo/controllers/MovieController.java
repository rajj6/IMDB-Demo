package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public Object home(Model model) {
        return movieService.getAllMovies();
    }

    @PostMapping("/movie")
    public Object saveMovie(@RequestParam(name = "name") String name,
                            @RequestParam(name = "yearOfRelease") int yearOfRelease,
                            @RequestParam(name = "plot") String plot,
                            @ModelAttribute("poster") MultipartFile poster,
                            @ModelAttribute("producer") String producer,
                            @ModelAttribute("actors") String actors) {
        movieService.saveMovie(name,yearOfRelease,plot,poster,producer, actors);
        return "Movie saved in Database";
    }

    @DeleteMapping("/movie/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovieById(id);
        return "Deleted movie with id: " + id;
    }

    @GetMapping("/movie/{id}")
    public Object getMovie(@PathVariable("id") Long id) {
        return movieService.getMovieById(id);
    }

    @PutMapping("/movie")
    public String updateMovie(@RequestParam("id") Long id,
                              @RequestParam(name = "name") String name,
                              @RequestParam(name = "yearOfRelease") int yearOfRelease,
                              @RequestParam(name = "plot") String plot,
                              @ModelAttribute("poster") MultipartFile poster,
                              @ModelAttribute("producer") String producer,
                              @ModelAttribute("actors") String actors) {
        movieService.updateMovie(id, name, yearOfRelease, plot, poster, producer, actors);
        return "Movie Updated";
    }
}
