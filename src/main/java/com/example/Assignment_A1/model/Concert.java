package com.example.Assignment_A1.model;

import jakarta.persistence.*;

@Entity
@Table
public class Concert {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idConcert;
    @Column
    private String name;
    @Column
    private String date;
    @Column
    private String time;
    @Column
    private int nrTickets;

    public Concert(){}

    public Concert(int idConcert, String name, String date, String time, int nrTickets) {
        this.idConcert = idConcert;
        this.name = name;
        this.date = date;
        this.time = time;
        this.nrTickets = nrTickets;
    }

    public Concert(String name, String date, String time, int nrTickets) {
        this.idConcert = idConcert;
        this.name = name;
        this.date = date;
        this.time = time;
        this.nrTickets = nrTickets;
    }

    public int getIdConcert() {
        return idConcert;
    }

    public void setIdConcert(int idConcert) {
        this.idConcert = idConcert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNrTickets() {
        return nrTickets;
    }

    public void setNrTickets(int nrTickets) {
        this.nrTickets = nrTickets;
    }
}
