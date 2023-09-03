package com.example.baseball_ticket_sale.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_number")
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="payment_number")
    private Payment payment;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="ticket_number")
    private Ticket ticket;



}