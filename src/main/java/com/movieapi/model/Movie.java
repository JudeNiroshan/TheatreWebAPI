package com.movieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */


@Entity
@Table(name = "movie")
public class Movie implements Serializable {

    private static final long serialVersionUID = -4211088410253930741L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column
    private int releasedYear;

    @Column
    private String director;

    @Column
    private String ratings;

    @Column(name = "name", length = 255)
    private String name;


    @JsonIgnore
    @OneToMany(mappedBy = "movie")
    private Set<MovieTheater> movieTheaters = new HashSet<MovieTheater>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MovieTheater> getMovieTheaters() {
        return movieTheaters;
    }

    public void setMovieTheaters(Set<MovieTheater> movieTheaters) {
        this.movieTheaters = movieTheaters;
    }

}
