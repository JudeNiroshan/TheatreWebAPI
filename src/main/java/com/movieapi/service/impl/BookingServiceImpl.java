package com.movieapi.service.impl;

import com.movieapi.model.Booking;
import com.movieapi.repository.BookingRepository;
import com.movieapi.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getBookingList() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking getBookingById(Long id) {
        return bookingRepository.findOne(id);
    }

    @Override
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking editBooking(Booking movie) {
        return bookingRepository.save(movie);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.delete(id);
    }
}
