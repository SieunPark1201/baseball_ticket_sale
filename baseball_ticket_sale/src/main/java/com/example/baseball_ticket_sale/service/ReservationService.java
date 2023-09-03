package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.domain.Reservation;
import com.example.baseball_ticket_sale.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public void create(Reservation reservation) throws SQLException {
        reservationRepository.save(reservation);
    }

    public List<Reservation> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }

}