package com.example.Assignment_A1.service;

import com.example.Assignment_A1.model.Band;
import com.example.Assignment_A1.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    public List<Band> getAllBands(){
        // return users;
        List<Band> bands = new ArrayList<>();
        bandRepository.findAll().forEach(u-> bands.add(u));
        return bands;
    }

    public Optional<Band> getBandById(int id){
        //return cashiers.stream().filter(u->u.getIdUser()==id).findFirst().get();
        return bandRepository.findById(id);
    }

    public void addBand(Band band){
        //users.add(user);
        bandRepository.save(band);
    }

    public void updateBand(int id, Band band){
        bandRepository.save(band);
    }

    public void deleteBand(int id){
        bandRepository.deleteById(id);
    }
}
