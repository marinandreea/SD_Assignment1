package com.example.Assignment_A1.controller;

import com.example.Assignment_A1.model.ConcertBands;
import com.example.Assignment_A1.service.ConcertBandsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableMethodSecurity
public class ConcertBandsController {

    @Autowired
    private ConcertBandsService concertBandsService;

    @RequestMapping("/concertbands")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ConcertBands> getAllConcertBands(){
        return concertBandsService.getAllConcerts();
    }

    @RequestMapping("/concertbands/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<ConcertBands> getConcertBands(@PathVariable int id){
        return concertBandsService.getConcertBandsById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/concertbands/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void addConcertBands(@RequestBody ConcertBands concertBands){
        concertBandsService.addConcertBands(concertBands);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/concertbands/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateConcertBands(@RequestBody ConcertBands concertBands, @PathVariable int id){
        concertBandsService.updateConcertBands(id, concertBands);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/concertbands/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteConcertBands(@PathVariable int id){
        concertBandsService.deleteConcertBands(id);
    }
}
