package com.raj.imdbdemo.dto;

import com.raj.imdbdemo.entity.Producer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProducerDTO implements Serializable {
    private Long id;
    private String name;
    private String sex;
    private Date DOB;   //DateOfBirth
    private String bio;

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