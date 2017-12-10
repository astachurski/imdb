package com.example.service;


import com.example.domain.Movie;
import com.example.domain.MovieCast;
import com.example.repository.MovieCastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieCastService {

    @Autowired
    private MovieCastRepository movieCastRepository;

    public void addMovieCast(MovieCast movieCast){
        movieCastRepository.save(movieCast);
    }

    public List<MovieCast> getCasts(){
        List<MovieCast> movieCasts = new ArrayList<>();
        movieCastRepository.findAll().forEach(e -> movieCasts.add(e));
        return movieCasts;
    }

    public void addCast(MovieCast movieCast){
        movieCastRepository.save(movieCast);
    }
}
