package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.Dto.SeatDto;
import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Payment;
import com.example.baseball_ticket_sale.domain.Seat;
import com.example.baseball_ticket_sale.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public void create(Seat seat) throws Exception {
        seatRepository.save(seat);
    }

    // 모든 좌석 조회
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }


//    예매가능 -> 예매불가 좌석 상태 변경
    public Seat update(SeatDto seatDto) throws Exception {
        Seat seat1 = seatRepository.findById(seatDto.getSeatId())
                .orElseThrow(Exception::new);
        seat1.setIsReservation(1);     // isReservation이 0이면 예매가능, 1이면 예매불가
        seatRepository.save(seat1);
        return seat1;
    }

//    예매가능한 좌석 조회
    public List<Seat> getAvailableSeatsByType(String seatType) {
        return seatRepository.findBySeatTypeAndIsReservation(seatType, 0); // 0은 예매 가능을 나타냅니다.
    }


    // 등급별 좌석 수 조회
    public int countBySeatType(String seatType) {
        List<Seat> seats = seatRepository.findBySeatTypeAndIsReservation(seatType, 0); // 0은 예약되지 않은 좌석을 나타내는 값입니다.
        return seats.size();
    }




}
