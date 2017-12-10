package com.example.service;

import com.example.domain.Movie;
import com.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;
/*
    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }*/

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovies(){
        List<Movie> results = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> results.add(movie));
        return results;
    }

    public void addMovies(List<Movie> movies){
        movieRepository.saveAll(movies);
    }

}
