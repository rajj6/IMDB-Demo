package com.raj.imdbdemo.dto;

import com.raj.imdbdemo.entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO implements Serializable {

    private Long id;
    private String name;
    private String sex;
    private Date DOB;   //DateOfBirth
    private String bio;

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