package com.example.baseball_ticket_sale.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ticketNumber;

    private String area;

    private String purchaseLimit;

    private int price;

    @JoinColumn(name="matchDay")
    @OneToOne
    private Match match;

}
