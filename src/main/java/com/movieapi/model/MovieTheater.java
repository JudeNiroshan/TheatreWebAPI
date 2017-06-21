package com.movieapi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */

@Entity
@Table(name = "movie_theater")
public class MovieTheater implements Serializable{


    private static final long serialVersionUID = 2358976164661397713L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movieId")
    private Movie movie;


    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }
}
