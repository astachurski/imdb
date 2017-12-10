package com.example.service;


import com.example.domain.Actor;
import com.example.domain.Movie;
import com.example.domain.MovieCast;
import com.example.repository.MovieCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieCastService {

    @Autowired
    private MovieCastRepository movieCastRepository;

    public List<MovieCast> getCasts() {
        List<MovieCast> movieCasts = new ArrayList<>();
        movieCastRepository.findAll().forEach(e -> movieCasts.add(e));
        return movieCasts;
    }

    public void addCast(MovieCast movieCast) {
        movieCastRepository.save(movieCast);
    }

    public List<Movie> getMoviesByActorLastName(String lastname) {
        List<Movie> results = new ArrayList<>();
        movieCastRepository.findMovieCastsByActor_Lastname(lastname)
                .forEach(cast -> results.add(cast.getMovie()));
        return results;
    }

    public List<Actor> getActorsByMovieTitle(String title) {
        List<Actor> results = new ArrayList<>();
        movieCastRepository.findMovieCastsByMovie_Title(title)
                .forEach(e -> results.add(e.getActor()));
        return results;
    }

    public List<Movie> getMoviesWithCastLessThan(Integer treshold) {
        List<Movie> results = new ArrayList<>();

        Iterable<MovieCast> casts = movieCastRepository.findAll();

        Map<Movie, Integer> castOccurenceMap = new HashMap<>();
        for (MovieCast cast : casts) {
            Movie movie = cast.getMovie();
            Actor actor = cast.getActor();
            if (!castOccurenceMap.containsKey(movie)) {
                if (actor != null)
                    castOccurenceMap.put(movie, 1);
            } else {
                Integer currOcurrence = castOccurenceMap.get(movie);
                castOccurenceMap.put(movie, currOcurrence + 1);
            }
        }

         Iterator<Map.Entry<Movie, Integer>> it = castOccurenceMap.entrySet().iterator();

         while (it.hasNext()){
             Map.Entry<Movie, Integer> entry = it.next();
             if (entry.getValue() < treshold)
                 results.add(entry.getKey());
         }
        return results;
    }


}
