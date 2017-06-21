package com.movieapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */

@Entity
@Table(name = "showtime")
public class Showtime implements Serializable {

    private static final long serialVersionUID = 6040264552792931243L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "theaterId")
    private Theater theater;


    @ManyToOne
    @JoinColumn(name = "movieId")
    private  Movie movie;

    @Column(name = "showTime")
    private String showTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
