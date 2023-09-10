package com.example.baseball_ticket_sale.Dto;

import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Reservation;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CancelDto {
    private Long cancelNumber;
    private String cancelStatus;
    private int refundFee;
    private String refundStatus;
    private Matching matching;
    private Reservation reservation;

}
