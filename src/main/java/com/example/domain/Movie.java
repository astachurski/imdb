package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Movie {

    private String title;
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private MovieDetail movieDetail;

    public void setMovieDetail(MovieDetail movieDetail) {
        this.movieDetail = movieDetail;
    }

    public MovieDetail getMovieDetail() {
        return movieDetail;
    }

    public Movie(String title){
        this.title = title;
    }

    public Movie(){
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
