package com.raj.imdbdemo.service;

import com.raj.imdbdemo.dto.MovieDTO;
import com.raj.imdbdemo.entity.Actor;
import com.raj.imdbdemo.entity.Movie;
import com.raj.imdbdemo.entity.Producer;
import com.raj.imdbdemo.exception.DataNotFound;
import com.raj.imdbdemo.repo.ActorRepository;
import com.raj.imdbdemo.repo.MovieRepository;
import com.raj.imdbdemo.repo.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ProducerRepository producerRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public void addActorsInMovie(Movie movie, String actors) {
        for (String actorName : actors.split(",")) {
            Actor actor = actorRepository.findActorByNameIgnoreCase(actorName.trim());
            if( actor != null ) {
                movie.getActors().add(actor);
            } else {
                movie.getActors().add(actorRepository.save(new Actor(actorName.trim())));
            }
        }
    }

    @Override
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

    @Override
    @CachePut(value = "movieDTO", key = "#id")
    public MovieDTO updateMovie(Long id, String name, Integer yearOdRelease, String plot, MultipartFile poster, String producerName, String actors) {
        Movie movie = movieRepository.findById(id).orElseThrow(()->new DataNotFound("Movie with id: "+id+" not found."));
        movie.setName(name);
        movie.setYearOfRelease(yearOdRelease);
        movie.setPlot(plot);
        movie.getActors().clear();
        addActorsInMovie(movie, actors);
        Producer producer = producerRepository.findProducerByNameIgnoreCase(producerName);
        if (producer != null) {
            movie.setProducer(producer);
        } else {
            movie.setProducer(producerRepository.save(new Producer(producerName)));
        }
        if (!poster.isEmpty()) {
            try {
                movie.setPoster(poster.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            movie.setImgType(poster.getContentType());
        }
        Movie movieSaved = movieRepository.save(movie);
        return MovieDTO.mapEntityToDTO(movieSaved);
    }

    @Override
    public void updateMovie(MovieDTO movieDTO, MultipartFile poster) {
        Movie movie = movieRepository.getOne(movieDTO.getId());
        movie.setName(movieDTO.getName());
        movie.setYearOfRelease(movieDTO.getYearOfRelease());
        movie.setPlot(movieDTO.getPlot());
        movie.getActors().clear();
        addActorsInMovie(movie, movieDTO.getActors());
        Producer producer = producerRepository.findProducerByNameIgnoreCase(movieDTO.getProducer());
        if (producer != null) {
            movie.setProducer(producer);
        } else {
            movie.setProducer(producerRepository.save(new Producer(movieDTO.getProducer())));
        }
        if (!poster.isEmpty()) {
            try {
                movie.setPoster(poster.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            movie.setImgType(poster.getContentType());
        }
        movieRepository.save(movie);
    }

    @Override
    @Cacheable(value = "movieDTO", key = "#id")
    public MovieDTO getMovieById(Long id) {
        return MovieDTO.mapEntityToDTO(movieRepository.findById(id).orElseThrow(()->new DataNotFound("Movie with id: "+id+" not found.")));
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for(Movie movie : movieRepository.findAll()) {
            movieDTOList.add(MovieDTO.mapEntityToDTO(movie));
        }
        return movieDTOList;
    }

    @Override
    @CacheEvict(value = "movieDTO", key = "#id")
    public void deleteMovieById(long id) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow(()->new DataNotFound("Movie with id: "+id+" not found."));
        movieRepository.delete(existingMovie);
    }

    @Override
    public List<MovieDTO> search(String keyword) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for(Movie movie : movieRepository.findAll(searchSpecification(keyword))) {
            movieDTOList.add(MovieDTO.mapEntityToDTO(movie));
        }
        return movieDTOList;
    }

    private Specification<Movie> searchSpecification(String keyword) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            criteriaQuery.distinct(true);
            if ((keyword ==null)) {
                return null;
            }
            return criteriaBuilder.or(
                    criteriaBuilder.like(root.get("name"), "%" + keyword + "%"),
                    criteriaBuilder.like(root.get("plot"), "%" + keyword + "%"),
                    criteriaBuilder.equal(root.join("actors").get("name"), keyword),
                    criteriaBuilder.equal(root.join("producer").get("name"), keyword)
            );
        });
    }
}