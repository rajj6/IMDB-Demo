package com.raj.imdbdemo.controllers;

import com.raj.imdbdemo.dto.MovieDTO;
import com.raj.imdbdemo.entity.TestEntity;
import com.raj.imdbdemo.repo.TestRepo;
import com.raj.imdbdemo.service.MovieService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class MainControllers {

    @Autowired
    MovieService movieService;

    @Autowired
    TestRepo testRepo;

    @GetMapping("/test")
    public String test(Model model) throws IOException {
        System.out.println("Inside Get ,Test method");
        TestEntity testEntity = testRepo.findById(1l).get();
        System.out.println(testEntity.getName());
        System.out.println(testEntity.getPic());

        byte[] encodeBase64 = Base64.encodeBase64(testEntity.getPic());
        String base64Encoded = new String(encodeBase64);
        model.addAttribute("epic", base64Encoded);
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
    public String home() {
        System.out.println("In side Home Method");
        return "home";
    }

    @GetMapping("/showNewMovieForm")
    public String newMovieForm(Model model) {
        System.out.println("Inside New Movie Form");
        model.addAttribute("movie", new MovieDTO());
        return "new_movie_form";
    }

    @PostMapping("/saveMovie")
    public String saveMovie(@RequestParam(name = "name") String name,
                            @RequestParam(name = "yearOfRelease") int yearOfRelease,
                            @RequestParam(name = "plot") String plot,
                            @ModelAttribute("poster") MultipartFile poster) {
        System.out.println("MainControllers.saveMovie + "+name+ yearOfRelease+plot+poster);
        movieService.saveMovie(name,yearOfRelease,plot,poster);
//        movieService.saveMovie(movie);
        return "redirect:/home";
    }
//    @PostMapping("/saveMovie")
//    public String saveMovie(@ModelAttribute("movie") MovieDTO movie) {
//        System.out.println("MainControllers.saveMovie + "+movie);
//        movieService.saveMovie(movie);
//        return "redirect:/home";
//    }
}
