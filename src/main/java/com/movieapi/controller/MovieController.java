package com.movieapi.controller;

import com.movieapi.model.Movie;
import com.movieapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@CrossOrigin(allowedHeaders="*",allowCredentials="true")
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    //get all movie info
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movieList = movieService.getMovieList();
        if (movieList.isEmpty()) {
            return new ResponseEntity<List<Movie>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Movie>>(movieList, HttpStatus.OK);
    }

    //get movie by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Movie> getMovie(@PathVariable("id") Long id){
        Movie movie = movieService.getMovieById(id);
        if(movie == null){
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Movie>(movie,HttpStatus.OK);
    }
}
