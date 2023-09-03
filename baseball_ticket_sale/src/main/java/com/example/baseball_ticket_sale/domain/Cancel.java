package com.example.baseball_ticket_sale.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Cancel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cancelNumber;

    @Column(length = 30)
    private String cancelStatus;

    private int refundFee;

    @Column(length = 30)
    private String refundStatus;

    @OneToOne
    @JoinColumn(name="match_day")
    private Matching matching;

    @OneToOne
    @JoinColumn(name="reservation_number")
    private Reservation reservation;

}