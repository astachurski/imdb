package com.example.repository;

import com.example.domain.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    public Actor findActorByFirstname(String name);
    public List<Actor> findAllByFirstname(String name);
}
