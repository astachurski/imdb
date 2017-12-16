package com.example.repository;

import com.example.domain.Movie;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;


public interface MovieRepository extends CrudRepository<Movie, Integer>{

}
