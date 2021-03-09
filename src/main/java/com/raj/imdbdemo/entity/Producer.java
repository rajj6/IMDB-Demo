package com.raj.imdbdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "producers")
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

    public Producer(String name) {
        this.name = name;
    }
}