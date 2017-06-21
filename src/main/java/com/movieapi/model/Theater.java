package com.movieapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */


@Entity
@Table(name = "theater")
public class Theater  implements Serializable {

    private static final long serialVersionUID = -5496912430149849347L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "noOfSeats")
    private int noOfSeats;

    @Column(name = "location")
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "theater")
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

    public int getNoOfSeats() {
        return noOfSeats;
    }

    public void setNoOfSeats(int noOfSeats) {
        this.noOfSeats = noOfSeats;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<MovieTheater> getMovieTheaters() {
        return movieTheaters;
    }

    public void setMovieTheaters(Set<MovieTheater> movieTheaters) {
        this.movieTheaters = movieTheaters;
    }

}
