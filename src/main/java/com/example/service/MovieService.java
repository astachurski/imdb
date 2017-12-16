package com.example.service;

import com.example.domain.Movie;
import com.example.repository.MovieDetailRepository;
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

    private MovieDetailRepository movieDetailRepository;

    @Autowired
    public void setMovieDetailRepository(MovieDetailRepository movieDetailRepository) {
        this.movieDetailRepository = movieDetailRepository;
    }

    public List<Movie> getMovies(){
        List<Movie> results = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> results.add(movie));
        return results;
    }

    public void addMovies(List<Movie> movies){
        for (Movie movie: movies) {
            if (movie.getMovieDetail()!= null){
                movieDetailRepository.save(movie.getMovieDetail());
            }
        }
//        movies.forEach(movie -> movieDetailRepository.save(movie.getMovieDetail()));
        movieRepository.saveAll(movies);
    }

}
