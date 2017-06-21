package com.movieapi.controller;

import com.movieapi.model.Booking;
import com.movieapi.model.User;
import com.movieapi.service.BookingService;
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
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    //get all movie info
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Booking>> getAllBookings() {
        List<Booking> bookingList = bookingService.getBookingList();
        if (bookingList.isEmpty()) {
            return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Booking>>(bookingList, HttpStatus.OK);
    }

    //get movie by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Booking> getBooking(@PathVariable("id") Long id){
        Booking booking = bookingService.getBookingById(id);
        if(booking == null){
            return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Booking>(booking,HttpStatus.OK);
    }

    //add booking
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Booking> addUser(@RequestBody Booking booking){
        Booking persistBooking = bookingService.addBooking(booking);
        return new ResponseEntity<Booking>(persistBooking,HttpStatus.CREATED);
    }


    //check seats availability
    @RequestMapping(value = "/checkseats",method = RequestMethod.POST)
    public ResponseEntity<String> checkSeat(@RequestBody Booking booking) {
        List<Booking> bookingList = bookingService.getBookingList();
        if (bookingList.isEmpty()) {
            return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("", HttpStatus.OK);
    }


}
