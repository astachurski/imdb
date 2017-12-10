package com.example;

import com.example.domain.Actor;
import com.example.domain.Movie;
import com.example.service.ActorService;
import com.example.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ImdbApplication implements CommandLineRunner {

	@Autowired
	ActorService actorService;
	@Autowired
	MovieService movieService;

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	    actorService.addActor(new Actor("Arnold", "Kowalski"));
		actorService.addActor(new Actor("Sylverster", "Stallone"));
		actorService.addActor(new Actor("Olaf", "Lubaszenko"));
        actorService.addActor(new Actor("Olaf", "Pompka"));
        actorService.addActor(new Actor("Tom", "Hanks"));
        actorService.addActor(new Actor("Michael", "Jackson"));

		Actor actorFound = actorService.getActorByName("Olaf");

        if (actorFound != null)
            System.out.printf(actorFound.toString());

        List<Actor> actorList = actorService.getActorsByName("Olaf");
        actorList.forEach(e -> System.out.printf(e.toString()));


        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Terminator"));
        movieList.add(new Movie("Mroczny Bean 2"));
        movieList.add(new Movie("Springiem i Mieczem"));
        movieList.add(new Movie("Pan Bean"));

        movieService.addMovies(movieList);


	     //List<Actor> actors = actorService.getAllActors();
	     //actors.forEach(actor -> System.out.printf(""));


	}
}
