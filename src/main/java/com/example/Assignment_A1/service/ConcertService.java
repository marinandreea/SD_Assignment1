package com.example.Assignment_A1.service;

import com.example.Assignment_A1.model.Concert;
import com.example.Assignment_A1.repository.ConcertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConcertService {

    @Autowired
    private ConcertRepository concertRepository;

    public List<Concert> getAllConcerts(){
        // return users;
        List<Concert> concerts = new ArrayList<>();
        concertRepository.findAll().forEach(u-> concerts.add(u));
        return concerts;
    }

    public Optional<Concert> getConcertById(int id){
        //return cashiers.stream().filter(u->u.getIdUser()==id).findFirst().get();
        return concertRepository.findById(id);
    }

    public void addConcert(Concert concert){
        //users.add(user);
        concertRepository.save(concert);
    }

    public void updateConcert(int id, Concert concert){
        concertRepository.save(concert);
    }

    public void deleteConcert(int id){
        concertRepository.deleteById(id);
    }
}
