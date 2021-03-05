package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.MovieDTO;
import com.raj.imdbdemo.entity.Actor;
import com.raj.imdbdemo.entity.Movie;
import com.raj.imdbdemo.entity.Producer;
import com.raj.imdbdemo.repo.ActorRepository;
import com.raj.imdbdemo.repo.MovieRepository;
import com.raj.imdbdemo.repo.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ActorRepository actorRepository;

    private void addActorsInMovie(Movie movie, String actors) {
        for (String actorName : actors.split(",")) {
            Actor actor = actorRepository.findActorByNameIgnoreCase(actorName);
            if( actor != null ) {
                movie.getActors().add(actor);
            } else {
                movie.getActors().add(actorRepository.save(new Actor(actorName)));
            }
        }
    }

//    public void saveMovie(MovieDTO movieDTO) {
////        Movie movie = new Movie(movieDTO.getName(), movieDTO.getYearOfRelease(), movieDTO.getPlot());
//        movieRepository.save(new Movie(movieDTO.getName(), movieDTO.getYearOfRelease(), movieDTO.getPlot()));
//    }
    public void saveMovie(String name, Integer yearOdRelease, String plot, MultipartFile poster, String producerName, String actors) {

        try {
            Movie movie = new Movie();
            movie.setName(name);
            movie.setYearOfRelease(yearOdRelease);
            movie.setPlot(plot);
            movie.setPoster(poster.getBytes());
            movie.setImgType(poster.getContentType());
            Producer producer = producerRepository.findProducerByNameIgnoreCase(producerName);
            if (producer != null) {
                movie.setProducer(producer);
            } else {
                movie.setProducer(producerRepository.save(new Producer(producerName)));
            }
            addActorsInMovie(movie, actors);
            movieRepository.save(movie);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MovieDTO getMovieById(Long id) {
        return MovieDTO.mapEntityToDTO(movieRepository.getOne(id));
    }
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for(Movie movie : movieRepository.findAll()) {
            movieDTOList.add(MovieDTO.mapEntityToDTO(movie));
        }
        return movieDTOList;
    }

    public void deleteMovieById(long id) {
        movieRepository.deleteById(id);
    }

//    public List<MovieDTO> getAllMovies() {
//        movieRepository.findAll();
//        List<MovieDTO> movieDTOList = new ArrayList<>();
//        for (Movie movie : movieRepository.findAll()) {
//            MovieDTO movieDTO = new MovieDTO();
//            movieDTO.
//            movieDTOList
//        }
//        return
//    }
}
