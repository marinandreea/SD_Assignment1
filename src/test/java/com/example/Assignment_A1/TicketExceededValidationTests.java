package com.example.Assignment_A1;

import com.example.Assignment_A1.model.Ticket;
import com.example.Assignment_A1.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TicketExceededValidationTests {


    @Test
    void testTicketExceededValidation(){

        Ticket t = new Ticket("Marin Andreea",1,150,0);
        int ok = 0; // validate method returns 0 if the nr of places is less than 1
        assertEquals(ok,t.validateNrPlaces(t.getPlaces()));



    }
}
