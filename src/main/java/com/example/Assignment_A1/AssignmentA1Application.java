package com.example.Assignment_A1;

import com.example.Assignment_A1.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssignmentA1Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AssignmentA1Application.class, args);

	}

	@Autowired
	private TicketService ticketService;
	@Override
	public void run(String... args) throws Exception {
		ticketService.getAllTickets();
	}


}
