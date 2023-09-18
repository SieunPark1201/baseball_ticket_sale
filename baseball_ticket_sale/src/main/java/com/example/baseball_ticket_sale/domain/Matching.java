package com.example.baseball_ticket_sale.domain;

import com.sun.istack.NotNull;
import lombok.*;
import net.bytebuddy.asm.Advice;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Matching {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

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
    public Matching(Long matchingId,String matchDayAndTime, String homeTeam, String awayTeam, String stadium) {
        this.matchingId = matchingId;
        this.matchDayAndTime = matchDayAndTime;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.stadium = stadium;
    }

}