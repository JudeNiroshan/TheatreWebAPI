package com.movieapi.controller;

import com.movieapi.model.Booking;
import com.movieapi.model.BookingRequest;
import com.movieapi.model.Movie;
import com.movieapi.model.Seat;
import com.movieapi.model.Theater;
import com.movieapi.model.User;
import com.movieapi.service.BookingService;
import com.movieapi.service.MovieService;
import com.movieapi.service.SeatService;
import com.movieapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@CrossOrigin(allowedHeaders = "*", allowCredentials = "true")
@RestController
@RequestMapping("/booking")
public class BookingController {

	@Autowired
	BookingService bookingService;

	@Autowired
	TheaterService theaterService;

	@Autowired
	MovieService movieService;

	@Autowired
	SeatService seatService;

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
	public ResponseEntity<Booking> getBooking(@PathVariable("id") Long id) {
		Booking booking = bookingService.getBookingById(id);
		if (booking == null) {
			return new ResponseEntity<Booking>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Booking>(booking, HttpStatus.OK);
	}

	//add booking
	@RequestMapping(value = "/createData", method = RequestMethod.POST)
	public ResponseEntity<Booking> addUser(@RequestBody BookingRequest bookingRequest) {

/*
		Theater theater = theaterService.getTheaterById(theatreId);
		Movie movie = movieService.getMovieById(movieId);*/
		Seat seat = seatService.getSeatById(Long.valueOf(bookingRequest.getNumberOfSeats()));

		Booking newBooking = new Booking();
		newBooking.setTheater(bookingRequest.getTheatre());
		newBooking.setMovie(bookingRequest.getMovie());
		newBooking.setSeat(seat);
		newBooking.setBookingDate(bookingRequest.getBookingDate());

		Booking persistBooking = bookingService.addBooking(newBooking);
		return new ResponseEntity<Booking>(persistBooking, HttpStatus.OK);
	}

	//check seats availability
	@RequestMapping(value = "/checkseats", method = RequestMethod.POST)
	public ResponseEntity<String> checkSeat(@RequestBody Booking booking) {
		List<Booking> bookingList = bookingService.getBookingList();
		if (bookingList.isEmpty()) {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

}
