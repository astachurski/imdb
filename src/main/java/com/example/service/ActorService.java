package com.example.service;

import com.example.domain.Actor;
import com.example.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors(){
        List<Actor> results = new ArrayList<>();
        Iterable<Actor> temp = actorRepository.findAll();
        temp.forEach(actor -> results.add(actor));
        return results;
    }

    public void addActor(Actor actor){
        actorRepository.save(actor);
    }

    public Actor getActorByName(String name){
       return actorRepository.findActorByFirstname(name);
    }
}
