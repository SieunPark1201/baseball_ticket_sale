package com.example.baseball_ticket_sale.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MatchingDto {

    private Long matchingId;
    private String matchDayAndTime;
    private String homeTeam;
    private String awayTeam;
    private String stardium;
    private String rainCancel;
    private LocalDateTime reservationTime;

}
