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

    private String cancelStatus;

    private int  refundFee;

    private String refundStatus;

    @OneToOne
    @JoinColumn(name="match_day")
    private Match match;

    @OneToOne
    @JoinColumn(name="reservation_number")
    private Reservation reservation;

}
