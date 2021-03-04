package com.raj.imdbdemo.repo;

import com.raj.imdbdemo.entity.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {
    Producer findProducerByNameIgnoreCase(String name);
}
