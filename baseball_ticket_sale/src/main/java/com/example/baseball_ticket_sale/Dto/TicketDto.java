package com.example.baseball_ticket_sale.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDto {

    private Long ticketNumber;

    private String area;

    private String amount;

    private int price;

}