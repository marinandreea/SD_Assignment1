package com.example.Assignment_A1.service;

import com.example.Assignment_A1.model.ConcertBands;
import com.example.Assignment_A1.repository.ConcertBandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConcertBandsService {

    @Autowired
    private ConcertBandsRepository concertBandsRepository;

    public List<ConcertBands> getAllConcerts(){
        // return users;
        List<ConcertBands> concerts = new ArrayList<>();
        concertBandsRepository.findAll().forEach(u-> concerts.add(u));
        return concerts;
    }

    public Optional<ConcertBands> getConcertBandsById(int id){
        //return cashiers.stream().filter(u->u.getIdUser()==id).findFirst().get();
        return concertBandsRepository.findById(id);
    }

    public void addConcertBands(ConcertBands concert){
        //users.add(user);
        concertBandsRepository.save(concert);
    }

    public void updateConcertBands(int id, ConcertBands concert){
        concertBandsRepository.save(concert);
    }

    public void deleteConcertBands(int id){
        concertBandsRepository.deleteById(id);
    }
}
