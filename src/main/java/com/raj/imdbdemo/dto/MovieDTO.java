package com.raj.imdbdemo.dto;

public class MovieDTO {

    private Long id;
    private String name;
    private Integer yearOfRelease;
    private String plot;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String name, Integer yearOfRelease, String plot) {
        this.id = id;
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.plot = plot;
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
                '}';
    }
}
