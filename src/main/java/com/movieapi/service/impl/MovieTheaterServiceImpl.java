package com.movieapi.service.impl;

import com.movieapi.model.MovieTheater;
import com.movieapi.repository.MovieTheaterRepository;
import com.movieapi.service.MovieTheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Service
public class MovieTheaterServiceImpl implements MovieTheaterService {

    @Autowired
    MovieTheaterRepository movieTheaterRepository;

    @Override
    public List<MovieTheater> getMovieTheaterList() {
        return movieTheaterRepository.findAll();
    }

    @Override
    public MovieTheater getMovieTheaterById(Long id) {
        return movieTheaterRepository.findOne(id);
    }

    @Override
    public MovieTheater addMovieTheater(MovieTheater movie) {
        return movieTheaterRepository.save(movie);
    }

    @Override
    public MovieTheater editMovieTheater(MovieTheater movie) {
        return movieTheaterRepository.save(movie);
    }

    @Override
    public void deleteMovieTheater(Long id) {
        movieTheaterRepository.delete(id);
    }

    @Override
    public List<MovieTheater> findMoviesListByTheatorId(Long theaterId) {
        return movieTheaterRepository.findMoviesListByTheatorId(theaterId);
    }
}
