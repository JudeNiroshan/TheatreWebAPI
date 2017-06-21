package com.movieapi.service;

import com.movieapi.model.Seat;
import com.movieapi.model.Showtime;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
public interface SeatService {
    List<Seat> getSeatList();
    Seat getSeatById(Long id);
    Seat addSeat(Seat seat);
    Seat editSeat(Seat seat);
    void deleteSeat(Long id);
}
