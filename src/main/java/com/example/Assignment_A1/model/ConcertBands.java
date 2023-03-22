package com.example.Assignment_A1.model;

import jakarta.persistence.*;

@Entity
@Table
public class ConcertBands {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column

    private int concertId;
    @Column
    private int bandId;


    public ConcertBands(){}

    public ConcertBands(int id, int concertId, int bandId) {
        this.id = id;
        this.concertId = concertId;
        this.bandId = bandId;

    }

    public ConcertBands(int concertId, int bandId) {
        this.concertId = concertId;
        this.bandId = bandId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public int getBandId() {
        return bandId;
    }

    public void setBandId(int bandId) {
        this.bandId = bandId;
    }


}
