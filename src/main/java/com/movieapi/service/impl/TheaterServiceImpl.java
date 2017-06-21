package com.movieapi.service.impl;

import com.movieapi.model.Theater;
import com.movieapi.repository.TheaterRepository;
import com.movieapi.service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Service
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterRepository theaterRepository;


    @Override
    public List<Theater> getTheaterList() {
        return theaterRepository.findAll();
    }

    @Override
    public Theater getTheaterById(Long id) {
        return theaterRepository.findOne(id);
    }

    @Override
    public Theater addTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public Theater editTheater(Theater theater) {
        return theaterRepository.save(theater);
    }

    @Override
    public void deleteTheater(Long id) {
        theaterRepository.delete(id);
    }
}
