package com.movieapi.controller;

import com.movieapi.model.Showtime;
import com.movieapi.service.ShowtimeService;
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
@RequestMapping("/showtime")
public class ShowtimeController {

    @Autowired
    ShowtimeService showtimeService;

    //get all showtimes info
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Showtime>> getAllShowtime() {
        List<Showtime> showtimeList = showtimeService.getShowtimeList();
        if (showtimeList.isEmpty()) {
            return new ResponseEntity<List<Showtime>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Showtime>>(showtimeList, HttpStatus.OK);
    }

    //get showtime by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Showtime> getShowtime(@PathVariable("id") Long id){
        Showtime showtime = showtimeService.getShowtimeById(id);
        if(showtime == null){
            return new ResponseEntity<Showtime>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Showtime>(showtime,HttpStatus.OK);
    }

    //get showtime by theater id and movie id
    @RequestMapping(value = "/{tid}/{mid}", method = RequestMethod.GET)
    public ResponseEntity<List<Showtime>> getShowtimeByTheaterIdMovieId(@PathVariable("tid") Long tid,
                                                                  @PathVariable("mid") Long mid){
        List<Showtime> showtimeList = showtimeService.findShowtimeListByTheatorIdMovieId(tid,mid);
        if(showtimeList.isEmpty()){
            return new ResponseEntity<List<Showtime>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Showtime>>(showtimeList,HttpStatus.OK);
    }



}
