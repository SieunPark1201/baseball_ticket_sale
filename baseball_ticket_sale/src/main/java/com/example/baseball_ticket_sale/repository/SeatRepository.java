package com.example.baseball_ticket_sale.repository;

import com.example.baseball_ticket_sale.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findBySeatType(String seatType);

    List<Seat> findBySeatTypeAndIsReservation(String seatType, int i);
}
