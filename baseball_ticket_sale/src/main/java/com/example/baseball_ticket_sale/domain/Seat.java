package com.example.baseball_ticket_sale.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatId;

    private String seatType;

    private int seatNumber;

//    private int seatCount;


    @ColumnDefault("0")
    private int isReservation;    // isReservation이 0이면 예매가능, 1이면 예매불가

    @ManyToOne
    @JoinColumn(name = "matching_id")
    private Matching matching;

    @Builder
    public Seat (long seatId, String seatType, int seatNumber, int seatCount, Matching matching, int isReservation) {
        this.seatId =seatId;
        this.seatType = seatType;
        this.seatNumber = seatNumber;
//        this.seatCount = seatCount;
        this.matching = matching;
        this.isReservation = isReservation;
    }


    public void setCount(int newCount) {
    }

}
