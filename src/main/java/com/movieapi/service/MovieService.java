package com.movieapi.service;

import com.movieapi.model.Movie;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
public interface MovieService {
    List<Movie> getMovieList();
    Movie getMovieById(Long id);
    Movie addMovie(Movie movie);
    Movie editMovie(Movie movie);
    void deleteMovie(Long id);
}
