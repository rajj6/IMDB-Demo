package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.MovieDTO;
import com.raj.imdbdemo.entity.TestEntity;
import com.raj.imdbdemo.repo.ProducerRepository;
import com.raj.imdbdemo.repo.TestRepo;
import com.raj.imdbdemo.service.MovieService;
import com.raj.imdbdemo.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainControllers {

    @Autowired
    MovieService movieService;

    @Autowired
    TestRepo testRepo;

    @Autowired
    ProducerRepository producerRepository;

    @GetMapping("/test")
    public String test(Model model) throws IOException {
        System.out.println("Inside Get ,Test method");
//        model.addAttribute("movie", movieService.getMovieById(2l));
//        TestEntity testEntity = testRepo.findById(1l).get();
//        System.out.println(testEntity.getName());
//        System.out.println(testEntity.getPic());
//
//        byte[] encodeBase64 = Base64.encodeBase64(testEntity.getPic());
//        String base64Encoded = new String(encodeBase64);
//        model.addAttribute("epic", base64Encoded);
        System.out.println(producerRepository.findProducerByNameIgnoreCase("Raj"));
        return "test";
    }

    @PostMapping("/test_upload")
    public String testUpload(@ModelAttribute("file") MultipartFile file) throws IOException {
        System.out.println("MainControllers.testUpload");
        System.out.println(file);
        System.out.println(file.getBytes());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());
        System.out.println(file.isEmpty());
        System.out.println(file.getOriginalFilename());

        TestEntity testEntity  = new TestEntity();
        testEntity.setName(file.getOriginalFilename());
        testEntity.setSize(file.getSize());
        testEntity.setType(file.getContentType());
        testEntity.setPic(file.getBytes());

        testRepo.save(testEntity);
        return "test";
    }

    @GetMapping({"/home", "/"})
    public String home(Model model) {
        System.out.println("In side Home Method");
        model.addAttribute("movies", movieService.getAllMovies());
        return "home";
    }

    @GetMapping("/showNewMovieForm")
    public String newMovieForm(Model model) {
        System.out.println("Inside New Movie Form");
//        model.addAttribute("movie", new MovieDTO());
        return "new_movie_form";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@RequestParam(name = "name") String name,
                            @RequestParam(name = "yearOfRelease") int yearOfRelease,
                            @RequestParam(name = "plot") String plot,
                            @ModelAttribute("poster") MultipartFile poster,
                            @ModelAttribute("producer") String producer,
                            @ModelAttribute("actors") String actors) {
        System.out.println("MainControllers.saveMovie + "+name+ yearOfRelease+plot+poster);
        movieService.saveMovie(name,yearOfRelease,plot,poster,producer, actors);
//        movieService.saveMovie(movie);
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
//        return "redirect:/home";
    }

    @PostMapping("/updateMovie")
    public String updateMovie(@ModelAttribute("movie") MovieDTO movie,
                              @ModelAttribute("poster") MultipartFile poster) {
        System.out.println("MainControllers.updateMovie");
        System.out.println(movie);
        System.out.println("HI printing poster");
        if(poster != null) {
            System.out.println("Null hai");
        }else {
            System.out.println("Null nhi hai");
        }
        System.out.println(poster.getContentType() == "");
        System.out.println(poster.isEmpty());
        movieService.updateMovie(movie, poster);
        return "redirect:/home";
    }

//    @PostMapping("/saveMovie")
//    public String saveMovie(@ModelAttribute("movie") MovieDTO movie) {
//        System.out.println("MainControllers.saveMovie + "+movie);
//        movieService.saveMovie(movie);
//        return "redirect:/home";
//    }
}
