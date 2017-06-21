package com.movieapi.controller;

import com.movieapi.model.Seat;
import com.movieapi.service.SeatService;
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
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    SeatService seatService;

    //get all seat info
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Seat>> getAllSeats() {
        List<Seat> seatList = seatService.getSeatList();
        if (seatList.isEmpty()) {
            return new ResponseEntity<List<Seat>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Seat>>(seatList, HttpStatus.OK);
    }

    //get seat by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Seat> getSeat(@PathVariable("id") Long id){
        Seat seat = seatService.getSeatById(id);
        if(seat == null){
            return new ResponseEntity<Seat>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Seat>(seat,HttpStatus.OK);
    }
}
