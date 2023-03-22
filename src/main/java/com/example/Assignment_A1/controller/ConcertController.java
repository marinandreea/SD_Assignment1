package com.example.Assignment_A1.controller;

import com.example.Assignment_A1.model.Concert;
import com.example.Assignment_A1.service.ConcertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableMethodSecurity
public class ConcertController {

    @Autowired
    private ConcertService concertService;

    @RequestMapping("/concert")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Concert> getAllConcerts(){
        return concertService.getAllConcerts();
    }

    @RequestMapping("/concert/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<Concert> getConcert(@PathVariable int id){
        return concertService.getConcertById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/concert/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void addConcert(@RequestBody Concert concert){
        concertService.addConcert(concert);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/concert/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateConcert(@RequestBody Concert concert, @PathVariable int id){
        concertService.updateConcert(id, concert);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/concert/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteConcert(@PathVariable int id){
        concertService.deleteConcert(id);
    }
}
