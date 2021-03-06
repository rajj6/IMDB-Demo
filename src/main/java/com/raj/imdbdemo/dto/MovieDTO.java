package com.raj.imdbdemo.dto;

import com.raj.imdbdemo.entity.Actor;
import com.raj.imdbdemo.entity.Movie;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;

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

    public MovieDTO() {
    }

    public MovieDTO(Movie movie) {

    }

    public String getEncodedPoster() {
        return encodedPoster;
    }

    public void setEncodedPoster(String encodedPoster) {
        this.encodedPoster = encodedPoster;
    }

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

    public MovieDTO(String name, Integer yearOfRelease, String plot, MultipartFile poster) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.plot = plot;
        this.poster = poster;
    }

    public MultipartFile getPoster() {
        return poster;
    }

    public void setPoster(MultipartFile poster) {
        this.poster = poster;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(Integer yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImgType() {
        return imgType;
    }

    public void setImgType(String imgType) {
        this.imgType = imgType;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public void setProducer(Movie movie) {
        this.producer = movie.getProducer().getName();
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public void setActors(Movie movie) {
        String actors = "";
        for (Actor actor : movie.getActors()) {
            actors += actor.getName() + ",";
        }
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", plot='" + plot + '\'' +
                ", poster=" + poster +
                '}';
    }
}
