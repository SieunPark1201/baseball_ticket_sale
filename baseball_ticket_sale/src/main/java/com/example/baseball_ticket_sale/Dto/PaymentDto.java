package com.example.baseball_ticket_sale.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentDto {

    private Long paymentNumber;

    private String paymentMethod;

    private String sale;

    private String pointUse;

    private String couponUse;

    private String price;

    private String paymentStatus;

}