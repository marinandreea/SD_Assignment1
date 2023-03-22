package com.example.Assignment_A1.controller;

import com.example.Assignment_A1.CSVFileGenerator;
import com.example.Assignment_A1.model.Concert;
import com.example.Assignment_A1.model.Ticket;
import com.example.Assignment_A1.service.ConcertService;
import com.example.Assignment_A1.service.TicketService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@EnableMethodSecurity
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private CSVFileGenerator csvFileGenerator;

    @RequestMapping("/ticket")
    @PreAuthorize("hasAuthority('CASHIER')")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @RequestMapping("/ticket/{id}")
    @PreAuthorize("hasAuthority('CASHIER')")
    public Optional<Ticket> getTicket(@PathVariable int id){
        return ticketService.getTicketById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/ticket/create")
    @PreAuthorize("hasAuthority('CASHIER')")
    public void addTicket(@RequestBody Ticket ticket) throws Exception {
        ticketService.addTicket(ticket);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/ticket/update/{id}")
    @PreAuthorize("hasAuthority('CASHIER')")
    public void updateTicket(@RequestBody Ticket ticket, @PathVariable int id){
        ticketService.updateTicket(id, ticket);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/ticket/delete/{id}")
    @PreAuthorize("hasAuthority('CASHIER')")
    public void deleteTicket(@PathVariable int id){
        ticketService.deleteTicket(id);
    }

    @GetMapping("/export-to-csv/{idConcert}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void exportToCSV(HttpServletResponse respons, @PathVariable int idConcert) throws IOException{
        respons.setContentType("tickets/csv");
        respons.addHeader("Content-Disposition", "attachment; filename=\"tickets.csv\"");
//        List<Ticket> tick = new ArrayList<>();
//        List<Ticket> tt = ticketService.getAllTickets();
//        for(Ticket t:tt){
//            if(t.getConcertId() == idConcert){
//                tick.add(t);
//            }
//        }
        csvFileGenerator.writeTicketsToCSV(ticketService.getAllTickets(),idConcert,respons.getWriter());
    }
}
