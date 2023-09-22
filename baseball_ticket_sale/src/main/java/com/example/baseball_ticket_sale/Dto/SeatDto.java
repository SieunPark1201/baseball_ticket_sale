package com.example.baseball_ticket_sale.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatDto {

    private Long id;

    private String seatType;

    private int seatNumber;

}
