package com.raj.imdbdemo.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    private Set<Actor> actors = new HashSet<>();
}