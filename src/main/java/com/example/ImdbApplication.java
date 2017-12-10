package com.example;

import com.example.domain.Actor;
import com.example.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImdbApplication implements CommandLineRunner {

	@Autowired
	ActorService actorService;

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	    actorService.addActor(new Actor("Arnold", "Kowalski"));

	    Actor actorFound = actorService.getActorByName("Arnold");

        System.out.printf(actorFound.toString());


	     //List<Actor> actors = actorService.getAllActors();
	     //actors.forEach(actor -> System.out.printf(""));


	}
}
