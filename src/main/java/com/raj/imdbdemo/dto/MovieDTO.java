package com.raj.imdbdemo.dto;

import com.raj.imdbdemo.entity.Actor;
import com.raj.imdbdemo.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {

    private Long id;
    private String name;
    private Integer yearOfRelease;
    private String plot;
    private MultipartFile poster;
    private String encodedPoster;
    private String imgType;

    private String producer = "";
    private String actors = "";

    public static MovieDTO mapEntityToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setName(movie.getName());
        movieDTO.setYearOfRelease(movie.getYearOfRelease());
        movieDTO.setPlot(movie.getPlot());
        movieDTO.setEncodedPoster(new String(Base64.encodeBase64(movie.getPoster())));
        movieDTO.setImgType(movie.getImgType());
        movieDTO.setProducer(movie);
        movieDTO.setActors(movie);
        return movieDTO;
    }

    // Overloaded
    public void setProducer(Movie movie) {
        this.producer = movie.getProducer().getName();
    }

    public void setActors(Movie movie) {
        String actors = "";
        for (Actor actor : movie.getActors()) {
            actors += actor.getName() + ",";
        }
        this.actors = actors;
    }
}