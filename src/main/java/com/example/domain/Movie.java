package com.example.domain;

import javax.persistence.*;

@Entity
public class Movie {

    private String title;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
   // @Cascade(CascadeType.DELETE)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
