package com.movieapi.model;

import java.io.Serializable;

/**
 * Created by Jude on 6/23/2017.
 */
public class BookingRequest implements Serializable{

	private Theater theatre;
	private Movie movie;
	private Integer numberOfSeats = 0;
	private String bookingDate = "";

	public Theater getTheatre() {
		return theatre;
	}

	public void setTheatre(Theater theatre) {
		this.theatre = theatre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
}
