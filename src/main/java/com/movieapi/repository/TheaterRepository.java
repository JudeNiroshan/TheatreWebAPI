package com.movieapi.repository;

import com.movieapi.model.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Repository
public interface TheaterRepository extends JpaRepository<Theater,Long> {

}
