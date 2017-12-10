package com.example.domain;

import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;

@Entity
public class MovieCast {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Actor actor;

    public MovieCast(Movie movie, Actor actor) {
        this.movie = movie;
        this.actor = actor;
    }

    public MovieCast(){}

    @Override
    public String toString() {
        return "MovieCast{" +
                "id=" + id +
                ", movie=" + movie.toString() +
                ", actor=" + actor.toString() +
                '}';
    }
}
