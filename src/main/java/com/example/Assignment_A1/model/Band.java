package com.example.Assignment_A1.model;

import jakarta.persistence.*;

@Entity
@Table
public class Band {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idBand;
    @Column
    private String name;
    @Column
    private String genre;

    public Band(){}

    public Band(int idBand, String name, String genre) {
        this.idBand = idBand;
        this.name = name;
        this.genre = genre;
    }

    public Band(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public int getIdBand() {
        return idBand;
    }

    public void setIdBand(int idBand) {
        this.idBand = idBand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
