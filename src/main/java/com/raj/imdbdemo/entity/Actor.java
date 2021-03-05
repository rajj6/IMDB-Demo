package com.raj.imdbdemo.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "actors")
public class Actor {

    @Id
    private Long id;
    private String name;
    private String sex;
    private Date DOB;   //DateOfBirth

    @Type(type = "org.hibernate.type.TextType")
    private String bio;

    public Actor() {
    }

    public Actor(String name, String sex, Date DOB, String bio) {
        this.name = name;
        this.sex = sex;
        this.DOB = DOB;
        this.bio = bio;
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

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Actors{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", DOB=" + DOB +
                ", bio='" + bio + '\'' +
                '}';
    }
}
