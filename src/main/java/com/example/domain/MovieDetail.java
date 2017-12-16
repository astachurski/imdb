package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
public class MovieDetail {

    @Id
    @GeneratedValue
    private Integer id;

    private String description;

    private Date releaseDate = Date.from(Instant.now());

    public Date getReleaseDate() {
        return releaseDate;
    }

    public MovieDetail(){

    }

    public MovieDetail(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
