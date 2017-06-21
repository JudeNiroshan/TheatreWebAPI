package com.movieapi.service;

import com.movieapi.model.Booking;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
public interface BookingService {

    List<Booking> getBookingList();
    Booking getBookingById(Long id);
    Booking addBooking(Booking booking);
    Booking editBooking(Booking movie);
    void deleteBooking(Long id);
}
