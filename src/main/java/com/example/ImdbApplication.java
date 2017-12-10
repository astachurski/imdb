package com.example;

import com.example.domain.Actor;
import com.example.domain.Movie;
import com.example.domain.MovieCast;
import com.example.service.ActorService;
import com.example.service.MovieCastService;
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
	@Autowired
	MovieCastService movieCastService;

	public static void main(String[] args) {
		SpringApplication.run(ImdbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        Actor actor1 = new Actor("Arnold", "Kowalski");
        actorService.addActor(actor1);

        Actor actor2 = new Actor("Sylverster", "Stallone");
        actorService.addActor(actor2);
        Actor actor3 = new Actor("Olaf", "Lubaszenko");
        actorService.addActor(actor3);
        Actor actor4 = new Actor("Olaf", "Pompka");
        actorService.addActor(actor4);
        Actor actor5 = new Actor("Tom", "Hanks");
        actorService.addActor(actor5);
        Actor actor6 = new Actor("Michael", "Jackson");
        actorService.addActor(actor6);

		Actor actorFound = actorService.getActorByName("Olaf");

        if (actorFound != null)
            System.out.printf(actorFound.toString());

        List<Actor> actorList = actorService.getActorsByName("Olaf");
        actorList.forEach(e -> System.out.printf(e.toString()));


        List<Movie> movieList = new ArrayList<>();
        Movie terminator = new Movie("Terminator");
        movieList.add(terminator);

        Movie mrocznyBean = new Movie("Mroczny Bean 2");
        movieList.add(mrocznyBean);
        Movie springiem_i_mieczem = new Movie("Springiem i Mieczem");
        movieList.add(springiem_i_mieczem);
        Movie pan_bean = new Movie("Pan Bean");
        movieList.add(pan_bean);

        movieService.addMovies(movieList);

        MovieCast movieCast1 = new MovieCast(mrocznyBean, actor1);
        MovieCast movieCast2 = new MovieCast(mrocznyBean, actor2);
        MovieCast movieCast3 = new MovieCast(springiem_i_mieczem, actor5);
        MovieCast movieCast4 = new MovieCast(springiem_i_mieczem, actor4);
        MovieCast movieCast5 = new MovieCast(springiem_i_mieczem, actor3);
        MovieCast movieCast6 =  new MovieCast(pan_bean, actor2);
        MovieCast movieCast7 = new MovieCast(pan_bean, actor6);

        movieCastService.addCast(movieCast1);
        movieCastService.addCast(movieCast2);
        movieCastService.addCast(movieCast3);
        movieCastService.addCast(movieCast4);
        movieCastService.addCast(movieCast5);
        movieCastService.addCast(movieCast6);
        movieCastService.addCast(movieCast7);

        //List<Actor> actors = actorService.getAllActors();
	     //actors.forEach(actor -> System.out.printf(""));


	}
}
