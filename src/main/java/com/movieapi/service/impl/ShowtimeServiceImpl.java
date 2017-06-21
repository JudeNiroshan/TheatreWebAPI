package com.movieapi.service.impl;

import com.movieapi.model.Showtime;
import com.movieapi.repository.ShowtimeRepository;
import com.movieapi.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Service
public class ShowtimeServiceImpl implements ShowtimeService {

    @Autowired
    ShowtimeRepository showtimeRepository;

    @Override
    public List<Showtime> getShowtimeList() {
        return showtimeRepository.findAll();
    }

    @Override
    public Showtime getShowtimeById(Long id) {
        return showtimeRepository.findOne(id);
    }

    @Override
    public Showtime addShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public Showtime editShowtime(Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @Override
    public void deleteShowtime(Long id) {
        showtimeRepository.delete(id);
    }

    @Override
    public List<Showtime> findShowtimeListByTheatorIdMovieId(Long theaterId, Long movieId) {
        return showtimeRepository.findShowtimeListByTheatorIdMovieId(theaterId,movieId);
    }
}
