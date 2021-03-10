package com.raj.imdbdemo.repo;

import com.raj.imdbdemo.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor findActorByNameIgnoreCase(String name);
}
