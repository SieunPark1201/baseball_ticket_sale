package com.example.baseball_ticket_sale.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatType;

    private int seatNumber;

    private int seatCount;

    private boolean isReservation;

    @ManyToOne
    @JoinColumn(name = "matching_id")
    private Matching matching;

    @Builder
    public Seat (String seatType, int seatNumber, int seatCount, Matching matching) {
        this.seatType = seatType;
        this.seatNumber = seatNumber;
        this.seatCount = seatCount;
        this.matching = matching;
    }

}
