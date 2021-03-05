package com.raj.imdbdemo.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer yearOfRelease;

    @Type(type = "org.hibernate.type.TextType")
    private String plot;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] poster;

    private String imgType;

    @ManyToOne
    private Producer producer;

    @ManyToMany
    private Set<Actor> actors;

    public Movie() {
    }

    public Movie(String name, Integer yearOfRelease, String plot, byte[] poster, String imgType) {
        this.name = name;
        this.yearOfRelease = yearOfRelease;
        this.plot = plot;
        this.poster = poster;
        this.imgType = imgType;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
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

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", plot='" + plot + '\'' +
                '}';
    }
}
