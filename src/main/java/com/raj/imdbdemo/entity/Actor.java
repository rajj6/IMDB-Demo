package com.raj.imdbdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "actors", uniqueConstraints = @UniqueConstraint(name = "Unique Name of Actor", columnNames = "name"))
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String sex;
    private Date DOB;   //DateOfBirth

    @Type(type = "org.hibernate.type.TextType")
    private String bio;

    @ManyToMany(mappedBy = "actors")
    private Set<Movie> movies = new HashSet<>();

    public Actor(String name) {
        this.name = name;
    }
}