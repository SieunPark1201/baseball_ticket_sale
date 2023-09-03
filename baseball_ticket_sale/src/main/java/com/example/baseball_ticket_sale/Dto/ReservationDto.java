package com.example.baseball_ticket_sale.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReservationDto {

    private Long reservationNumber;

    private String orderStatus;

    private String refundStatus;

    private String refundMoney;

}