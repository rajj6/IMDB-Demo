package com.raj.imdbdemo.dto;

import com.raj.imdbdemo.entity.Actor;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ActorDTO {

    private Long id;
    private String name;
    private String sex;
    private Date DOB;   //DateOfBirth
    private String bio;

    @Override
    public String toString() {
        return "ActorDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", DOB=" + DOB +
                ", bio='" + bio + '\'' +
                '}';
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

    public ActorDTO() {
    }

    public ActorDTO(Long id, String name, String sex, Date DOB, String bio) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.DOB = DOB;
        this.bio = bio;
    }

    public static ActorDTO mapEntityToDTO(Actor actor) {
        return new ActorDTO(actor.getId(), actor.getName(), actor.getSex(), actor.getDOB(), actor.getBio());
    }

    public static List<ActorDTO> mapEntityToDTO(List<Actor> actors) {
        List<ActorDTO> actorDTOS = new ArrayList<>();
        for (Actor actor : actors) {
            actorDTOS.add(mapEntityToDTO(actor));
        }
        return actorDTOS;
    }
}
