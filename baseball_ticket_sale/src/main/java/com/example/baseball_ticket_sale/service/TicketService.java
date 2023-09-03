package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.domain.Ticket;
import com.example.baseball_ticket_sale.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public void create(Ticket ticket) throws Exception {
        ticketRepository.save(ticket);
    }

    public List<Ticket> findAll() {
        List<Ticket> tickets = ticketRepository.findAll();
        return tickets;
    }

    public Ticket find(Long ticketNumber) {
        return ticketRepository.findById(ticketNumber).orElse(null);
    }

}