package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.MovieDTO;
import com.raj.imdbdemo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MainControllers {

    @Autowired
    MovieService movieService;

    @GetMapping({"/home", "/"})
    public String home(Model model) {
        model.addAttribute("movies", movieService.getAllMovies());
        return "home";
    }

    @GetMapping("/showNewMovieForm")
    public String newMovieForm(Model model) {
        return "new_movie_form";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@RequestParam(name = "name") String name,
                            @RequestParam(name = "yearOfRelease") int yearOfRelease,
                            @RequestParam(name = "plot") String plot,
                            @ModelAttribute("poster") MultipartFile poster,
                            @ModelAttribute("producer") String producer,
                            @ModelAttribute("actors") String actors) {
        movieService.saveMovie(name,yearOfRelease,plot,poster,producer, actors);
        return "redirect:/home";
    }

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable("id") Long id) {
        movieService.deleteMovieById(id);
        return "redirect:/home";
    }

    @GetMapping("/editMovie/{id}")
    public String editMovie(@PathVariable("id") Long id, Model model) {
        model.addAttribute("movie",movieService.getMovieById(id));
        return "edit_movie_form";
    }

    @PostMapping("/updateMovie")
    public String updateMovie(@ModelAttribute("movie") MovieDTO movie,
                              @ModelAttribute("poster") MultipartFile poster) {
        movieService.updateMovie(movie, poster);
        return "redirect:/home";
    }
}
