package com.example.baseball_ticket_sale.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationNumber;

    private String orderStatus;

    private String refundStatus;

    private String refundMoney;

    LocalDateTime createDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private List<Member> members;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="paymentNumber")
    private Payment payment;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="ticketNumber")
    private List<Ticket> tickets;



}