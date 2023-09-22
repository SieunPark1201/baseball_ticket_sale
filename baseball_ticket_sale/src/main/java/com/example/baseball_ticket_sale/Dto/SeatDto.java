package com.example.baseball_ticket_sale.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDto {

    private Long seatId;

    private String seatType;

    private int seatNumber;

    private int isReservation;

}
