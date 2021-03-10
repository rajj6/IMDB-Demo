package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.MovieDTO;
import com.raj.imdbdemo.entity.Movie;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MovieService {

    void addActorsInMovie(Movie movie, String actors);
    void saveMovie(String name, Integer yearOdRelease, String plot, MultipartFile poster, String producerName, String actors);
    MovieDTO updateMovie(Long id, String name, Integer yearOdRelease, String plot, MultipartFile poster, String producerName, String actors);
    void updateMovie(MovieDTO movieDTO, MultipartFile poster);
    MovieDTO getMovieById(Long id);
    List<MovieDTO> getAllMovies();
    void deleteMovieById(long id);
}
