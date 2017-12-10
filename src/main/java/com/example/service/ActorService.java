package com.example.service;

import com.example.domain.Actor;
import com.example.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.persistence.NonUniqueResultException;
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
        Actor result = null;
        try {
            result = actorRepository.findActorByFirstname(name);
        } catch (Exception e){

            System.out.printf("error !");
        }
        return result;
    }

    public List<Actor> getActorsByName(String name){
        return actorRepository.findAllByFirstname(name);
    }
}
