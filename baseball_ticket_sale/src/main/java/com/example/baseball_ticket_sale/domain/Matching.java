package com.example.baseball_ticket_sale.domain;


import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "matching")
public class Matching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "matching_id")
    private Long matchingId;

    @NotNull
    private String matchDayAndTime;

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

    @Builder
    public Matching(Long matchingId, String matchDayAndTime, String homeTeam, String awayTeam, String stadium) {
        this.matchingId = matchingId;
        this.matchDayAndTime = matchDayAndTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
    }

}