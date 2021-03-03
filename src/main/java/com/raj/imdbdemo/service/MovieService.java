package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.MovieDTO;
import com.raj.imdbdemo.entity.Movie;
import com.raj.imdbdemo.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public void saveMovie(MovieDTO movieDTO) {
//        Movie movie = new Movie(movieDTO.getName(), movieDTO.getYearOfRelease(), movieDTO.getPlot());
        movieRepository.save(new Movie(movieDTO.getName(), movieDTO.getYearOfRelease(), movieDTO.getPlot()));
    }
}
