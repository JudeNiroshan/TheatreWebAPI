package com.movieapi.service;

import com.movieapi.model.MovieTheater;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
public interface MovieTheaterService {
    List<MovieTheater> getMovieTheaterList();
    MovieTheater getMovieTheaterById(Long id);
    MovieTheater addMovieTheater(MovieTheater movie);
    MovieTheater editMovieTheater(MovieTheater movie);
    void deleteMovieTheater(Long id);
    List<MovieTheater> findMoviesListByTheatorId(Long theaterId);
}
