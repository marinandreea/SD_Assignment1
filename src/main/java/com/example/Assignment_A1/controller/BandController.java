package com.example.Assignment_A1.controller;

import com.example.Assignment_A1.model.Band;
import com.example.Assignment_A1.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableMethodSecurity
public class BandController {

    @Autowired
    private BandService bandService;

    @RequestMapping("/band")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Band> getAllBand(){
        return bandService.getAllBands();
    }

    @RequestMapping("/band/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<Band> getBand(@PathVariable int id){
        return bandService.getBandById(id);
    }

    @RequestMapping(method = RequestMethod.POST,value = "/band/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void addBand(@RequestBody Band band){
        bandService.addBand(band);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/band/update/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateBand(@RequestBody Band band, @PathVariable int id){
        bandService.updateBand(id, band);
    }

    @RequestMapping(method = RequestMethod.DELETE,value="/band/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteBand(@PathVariable int id){
        bandService.deleteBand(id);
    }
}
