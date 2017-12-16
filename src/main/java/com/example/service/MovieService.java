package com.example.service;

import com.example.domain.Movie;
import com.example.repository.MovieDetailRepository;
import com.example.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

/*
    @Autowired
    public void setMovieRepository(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }*/

    public List<Movie> getMoviesViaJdbc() {

        String query = "SELECT * from movie";
        List<Map<String, Object>> res = jdbcTemplate.queryForList(query);
        List<Movie> result = new ArrayList<>();
        if (res.size() > 0) {
            for (Map item : res) {
                Movie movie = new Movie((String) item.get("title"));
                result.add(movie);
            }
        }
        return result;
    }

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private MovieDetailRepository movieDetailRepository;

    @Autowired
    public void setMovieDetailRepository(MovieDetailRepository movieDetailRepository) {
        this.movieDetailRepository = movieDetailRepository;
    }


    public List<Movie> getMovies() {
        List<Movie> results = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> results.add(movie));
        return results;
    }

    public void addMovies(List<Movie> movies) {
        for (Movie movie : movies) {
            if (movie.getMovieDetail() != null) {
                movieDetailRepository.save(movie.getMovieDetail());
            }
        }
//        movies.forEach(movie -> movieDetailRepository.save(movie.getMovieDetail()));
        movieRepository.saveAll(movies);
    }

}
