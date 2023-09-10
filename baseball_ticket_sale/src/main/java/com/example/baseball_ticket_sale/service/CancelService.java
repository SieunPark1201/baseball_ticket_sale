package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.domain.Cancel;
import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Reservation;
import com.example.baseball_ticket_sale.repository.CancelRepository;
import com.example.baseball_ticket_sale.repository.MatchingRepository;
import com.example.baseball_ticket_sale.repository.ReservationRepository;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelService {

    @Autowired
    private CancelRepository cancelRepository;
    @Autowired
    private MatchingRepository matchingRepository;
    @Autowired
    private ReservationRepository reservationRepository;


//    취소 조회하기

//    취소하기
    public Cancel cancelReservation(Long matchId, Long reservationId){
        // Match와 Reservation을 사용하여 Cancel 엔티티 생성
        Matching matching = new Matching();
        matching.setMatchingId(matchId);

        Reservation reservation = new Reservation();
        reservation.setReservationNumber(reservationId);

        Cancel cancel = new Cancel();
        cancel.setMatching(matching);
        cancel.setReservation(reservation);
        cancel.setCancelStatus(true); // 예약 취소 상태 설정

        // 취소 수수료 계산 및 설정
        int cancelFee = (int) calculateCancelFee(); // 취소 수수료 계산 로직 구현
        cancel.setRefundFee(cancelFee);

        // 취소 정보 저장
        return cancelRepository.save(cancel);
    }

    private double calculateCancelFee() {
        // 취소 수수료 계산 로직을 여기에 구현
        return 0.0; // 임시로 0.0으로 설정
    }


//    환불 상태 어떤 식으로 정의??

}
