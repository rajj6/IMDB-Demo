package com.raj.imdbdemo.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "producers", uniqueConstraints = @UniqueConstraint(name = "Unique Name of Producer", columnNames = "name"))
public class Producer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String sex;
    private Date DOB;

    @Type(type = "org.hibernate.type.TextType")
    private String bio;

    @OneToMany(mappedBy = "producer")
    private Collection<Movie> movies;

    public Long getId() {
        return id;
    }

    public Producer(String name) {
        this.name = name;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getBio() {
        return bio;
    }

    public Collection<Movie> getMovies() {
        return movies;
    }

    public void setMovies(Collection<Movie> movies) {
        this.movies = movies;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Producer(String name, String sex, Date DOB, String bio) {
        this.name = name;
        this.sex = sex;
        this.DOB = DOB;
        this.bio = bio;
    }

    public Producer() {
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", DOB=" + DOB +
                ", bio='" + bio + '\'' +
                ", movies=" + movies +
                '}';
    }
}
