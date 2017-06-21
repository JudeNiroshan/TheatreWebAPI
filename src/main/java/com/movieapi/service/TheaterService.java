package com.movieapi.service;

import com.movieapi.model.Theater;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
public interface TheaterService {
    List<Theater> getTheaterList();
    Theater getTheaterById(Long id);
    Theater addTheater(Theater theater);
    Theater editTheater(Theater theater);
    void deleteTheater(Long id);
}
