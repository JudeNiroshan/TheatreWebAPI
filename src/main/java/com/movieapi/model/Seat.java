package com.movieapi.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by MF Fazeel Mohamed on 6/4/2017.
 */
@Entity
@Table(name = "seat")
public class Seat implements Serializable {


    private static final long serialVersionUID = 7091152900255112056L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "seatNo")
    private int seatNo;

    @Column(name = "price")
    private double price;

    @Column(name = "availability",columnDefinition = "tinyint default true")
    private boolean availability;

    @OneToOne
    @JoinColumn(name = "theaterId",referencedColumnName="id")
    private Theater theater;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

}
