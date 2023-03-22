package com.example.Assignment_A1.model;

import jakarta.persistence.*;

@Entity
@Table
public class Ticket {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idTicket;
    @Column
    private String name;
    @Column
    private int concertId;
    @Column
    private int price;
    @Column
    private int places;

    public Ticket(){}

    public Ticket(int idTicket, String name, int concertId, int price, int places) {
        this.idTicket = idTicket;
        this.name = name;
        this.concertId = concertId;
        this.price = price;
        this.places = places;
    }

    public Ticket(String name, int concertId, int price, int places) {
        this.name = name;
        this.concertId = concertId;
        this.price = price;
        this.places = places;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public int validateNrPlaces(int places){
        if(places < 1){
            return 0;
        }else{
            return 1;
        }
    }
}
