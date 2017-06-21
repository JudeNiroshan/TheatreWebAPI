package com.movieapi.repository;

import com.movieapi.model.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {

    @Query(value = "select * from showtime where theater_id = ?1 and movie_id=?2", nativeQuery = true)
    List<Showtime> findShowtimeListByTheatorIdMovieId(Long theaterId,Long movieId);
}