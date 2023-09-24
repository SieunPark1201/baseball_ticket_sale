package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.Dto.ReservationDto;
import com.example.baseball_ticket_sale.domain.Reservation;
import com.example.baseball_ticket_sale.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;


//    예약 생성
    public void create(Reservation reservation) throws SQLException {
        reservationRepository.save(reservation);
    }


//    예약 조회
    public List<Reservation> findAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations;
    }


//    특정 회원의 예약 리스트 조회
    public List<Reservation> findById(Long memberId) {
        List<Reservation> reservationsOfMember = reservationRepository.findAllById(Collections.singleton(memberId));
        return reservationsOfMember;
    }


//    예약 상태 변경
    public Reservation update(ReservationDto reservationDto) throws Exception {
        Reservation reservation1 = reservationRepository.findById(reservationDto.getReservationNumber())
                .orElseThrow(Exception::new);
        reservation1.setRefundStatus(reservation1.getRefundStatus());
        reservation1.setOrderStatus(reservation1.getOrderStatus());
        reservationRepository.save(reservation1);
        return reservation1;
    }



//    예약 취소
    public void delete(Long reservationNumber, ReservationDto reservationDto){
        Reservation reservation1 = reservationRepository.findById(reservationNumber)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        reservationRepository.delete(reservation1);

    }

}