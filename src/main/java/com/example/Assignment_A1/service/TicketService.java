package com.example.Assignment_A1.service;

import com.example.Assignment_A1.model.Concert;
import com.example.Assignment_A1.model.ConcertBands;
import com.example.Assignment_A1.model.Ticket;

import com.example.Assignment_A1.repository.ConcertRepository;
import com.example.Assignment_A1.repository.TicketRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ConcertRepository concertRepository;


    public List<Ticket> getAllTickets(){
        // return users;
        List<Ticket> tickets = new ArrayList<>();
        ticketRepository.findAll().forEach(u-> tickets.add(u));
        return tickets;
    }

    public Optional<Ticket> getTicketById(int id){
        //return cashiers.stream().filter(u->u.getIdUser()==id).findFirst().get();
        return ticketRepository.findById(id);
    }

    public void addTicket(Ticket ticket) throws Exception {
        //users.add(user);
       // ticketRepository.save(ticket);
        if(ticket.validateNrPlaces(ticket.getPlaces()) == 1) {
            int idConcert = ticket.getConcertId();
            Optional<Concert> c = concertRepository.findById(idConcert);
            int nrTickets = c.get().getNrTickets() - ticket.getPlaces();
            if (nrTickets >= 0) {
                ticketRepository.save(ticket);
                c.get().setNrTickets(nrTickets);
                concertRepository.save(c.get());
            } else {
                //return "Number of tickets was exceeded. There are " + c.get().getNrTickets() + " tickets left!";
                System.out.println("Number of tickets was exceeded. There are " + c.get().getNrTickets() + " tickets left!");
            }
        }else{
            System.out.println("Number of places is below 1!");

        }
    }

    public void updateTicket(int id, Ticket ticket){

        Optional<Ticket> t = ticketRepository.findById(ticket.getIdTicket());
        Optional<Concert> concert = concertRepository.findById(ticket.getConcertId());
        int diff = t.get().getPlaces() - ticket.getPlaces();
        concert.get().setNrTickets(concert.get().getNrTickets() + diff);
        ticketRepository.save(ticket);
        concertRepository.save(concert.get());
    }

    public void deleteTicket(int id){
       Optional<Ticket> t = getTicketById(id);
       int idConcert = t.get().getConcertId();
        Optional<Concert> c = concertRepository.findById(idConcert);
        int nrTickets = c.get().getNrTickets() + t.get().getPlaces();
        ticketRepository.deleteById(id);
        c.get().setNrTickets(nrTickets);
        concertRepository.save(c.get());

    }
}
