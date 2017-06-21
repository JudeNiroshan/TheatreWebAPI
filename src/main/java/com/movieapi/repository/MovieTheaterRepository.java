package com.movieapi.repository;

import com.movieapi.model.MovieTheater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Repository
public interface MovieTheaterRepository extends JpaRepository<MovieTheater,Long> {

    @Query(value = "select * from movie_theater where theater_id = ?1", nativeQuery = true)
    List<MovieTheater> findMoviesListByTheatorId(Long theaterId);
}
