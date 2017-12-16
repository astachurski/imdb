package com.example.domain;



import org.springframework.beans.factory.annotation.Required;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


import javax.persistence.*;

@Entity
public class MovieCast {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    //@Cascade(CascadeType.DELETE)
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public Actor getActor() {
        return actor;
    }

    @ManyToOne
    //@Cascade(CascadeType.DELETE)
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
