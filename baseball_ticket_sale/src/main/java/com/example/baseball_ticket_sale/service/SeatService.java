package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Seat;
import com.example.baseball_ticket_sale.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public void create(Seat seat) throws Exception {
        seatRepository.save(seat);
    }

}
