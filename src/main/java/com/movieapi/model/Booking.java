package com.movieapi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */

@Entity
@Table(name = "booking")
public class Booking implements Serializable {

    private static final long serialVersionUID = -3899152558551247794L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "date")
    private String bookingDate;

    @OneToOne
    @JoinColumn(name = "theaterId",referencedColumnName="id")
    private Theater theater;

    @OneToOne
    @JoinColumn(name = "seatId",referencedColumnName="id")
    private Seat seat;

    @OneToOne
    @JoinColumn(name = "movieId",referencedColumnName="id")
    private Movie movie;

    @OneToOne
    @JoinColumn(name = "showtimeId",referencedColumnName="id")
    private Showtime showtime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }
}
