package com.raj.imdbdemo.dto;

import com.raj.imdbdemo.entity.Actor;
import com.raj.imdbdemo.entity.Producer;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProducerDTO {
    private Long id;
    private String name;
    private String sex;
    private Date DOB;   //DateOfBirth
    private String bio;

    @Override
    public String toString() {
        return "ProducerDTO{" +
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

    public ProducerDTO(Long id, String name, String sex, Date DOB, String bio) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.DOB = DOB;
        this.bio = bio;
    }

    public ProducerDTO() {
    }

    public static ProducerDTO mapEntityToDTO(Producer producer) {
        return new ProducerDTO(producer.getId(), producer.getName(), producer.getSex(), producer.getDOB(), producer.getBio());
    }

    public static List<ProducerDTO> mapEntityToDTO(List<Producer> producers) {
        List<ProducerDTO> producerDTOS = new ArrayList<>();
        for (Producer producer : producers) {
            producerDTOS.add(mapEntityToDTO(producer));
        }
        return producerDTOS;
    }
}
