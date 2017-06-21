package com.movieapi.service.impl;

import com.movieapi.model.Seat;
import com.movieapi.repository.SeatRepository;
import com.movieapi.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepository seatRepository;


    @Override
    public List<Seat> getSeatList() {
        return seatRepository.findAll();
    }

    @Override
    public Seat getSeatById(Long id) {
        return seatRepository.findOne(id);
    }

    @Override
    public Seat addSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seat editSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(Long id) {
        seatRepository.delete(id);
    }
}
