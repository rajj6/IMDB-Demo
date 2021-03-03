package com.raj.imdbdemo.dto;

import org.springframework.web.multipart.MultipartFile;

public class MovieDTO {

    private Long id;
    private String name;
    private Integer yearOfRelease;
    private String plot;
    private MultipartFile poster;

    public MovieDTO() {
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
