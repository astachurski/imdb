package com.example.repository;

import com.example.domain.MovieCast;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieCastRepository extends CrudRepository<MovieCast, Integer>{
    List<MovieCast> findMovieCastsByActor_Lastname(String lname);
    List<MovieCast> findMovieCastsByMovie_Title(String title);
}

