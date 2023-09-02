package com.example.baseball_ticket_sale.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Match {

    @Id
    @NotNull
    private String matchDay;

    @NotNull
    private String time;

    @NotNull
    private String homeTeam;

    @NotNull
    private String awayTeam;

    @NotNull
    private String stadium;

    @NotNull
    private String rainCancel;

    @NotNull
    private String reservationTime;

}