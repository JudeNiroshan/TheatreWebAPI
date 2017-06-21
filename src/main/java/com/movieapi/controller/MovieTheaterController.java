package com.movieapi.controller;

import com.movieapi.model.Movie;
import com.movieapi.model.MovieTheater;
import com.movieapi.service.MovieTheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/movieTheater")
public class MovieTheaterController {

    @Autowired
    MovieTheaterService movieTheaterService;
    // theater/1/movie
    @RequestMapping(value = "/{id}/movie", method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getMoviesListByTheaterId(@PathVariable("id") Long id){
        List<MovieTheater> theaterList = movieTheaterService.findMoviesListByTheatorId(id);

        List<Movie> movieList = new ArrayList<>();
        for(MovieTheater theater : theaterList){
            movieList.add(theater.getMovie());
        }
        if(movieList.isEmpty()){
            return new ResponseEntity<List<Movie>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Movie>>(movieList,HttpStatus.OK);
    }
}
