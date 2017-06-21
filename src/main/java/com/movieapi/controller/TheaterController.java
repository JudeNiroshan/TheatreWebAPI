package com.movieapi.controller;

import com.movieapi.model.Theater;
import com.movieapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    //get all theaters info
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Theater>> getAllTheaters() {
        List<Theater> theaterList = theaterService.getTheaterList();
        if (theaterList.isEmpty()) {
            return new ResponseEntity<List<Theater>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Theater>>(theaterList, HttpStatus.OK);
    }

    //get theater by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Theater> getUser(@PathVariable("id") Long id){
        Theater theater = theaterService.getTheaterById(id);
        if(theater == null){
            return new ResponseEntity<Theater>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Theater>(theater,HttpStatus.OK);
    }





}
