package com.movieapi.service;

import com.movieapi.model.Showtime;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
public interface ShowtimeService {
    List<Showtime> getShowtimeList();
    Showtime getShowtimeById(Long id);
    Showtime addShowtime(Showtime showtime);
    Showtime editShowtime(Showtime showtime);
    void deleteShowtime(Long id);
    List<Showtime> findShowtimeListByTheatorIdMovieId(Long theaterId,Long movieId);
}
