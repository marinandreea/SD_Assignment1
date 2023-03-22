package com.example.Assignment_A1.repository;

import com.example.Assignment_A1.model.Concert;
import com.example.Assignment_A1.model.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {


}