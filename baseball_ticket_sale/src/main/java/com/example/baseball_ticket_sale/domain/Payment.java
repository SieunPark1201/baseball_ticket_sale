package com.example.baseball_ticket_sale.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentNumber;

    private String paymentMethod;

    private String sale;

    private String pointUse;

    private String couponUse;

    private String price;

    private String paymentStatus;

    private LocalDateTime createDate;

    @OneToOne
    @JoinColumn(name="reservation_id")
    private Reservation reservation;

}