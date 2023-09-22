package com.example.baseball_ticket_sale.service;


import com.example.baseball_ticket_sale.Dto.MemberDto;
import com.example.baseball_ticket_sale.Dto.PaymentDto;
import com.example.baseball_ticket_sale.domain.Member;
import com.example.baseball_ticket_sale.domain.Payment;
import com.example.baseball_ticket_sale.repository.PaymentRepository;
import com.example.baseball_ticket_sale.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    ReservationRepository reservationRepository;


    //    결제정보 생성
    public void create(Payment payment) {
        paymentRepository.save(payment);
    }

    //        결제 정보 조회
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }



//    결제 정보 업데이트
    public Payment update(PaymentDto paymentDto) throws Exception {
        Payment payment1 = paymentRepository.findById(Long.parseLong(Integer.toString(Math.toIntExact(paymentDto.getPaymentNumber()))))
                .orElseThrow(Exception::new);
        payment1.setPaymentMethod(payment1.getPaymentMethod());
//        payment1.setPrice(); //price 계산하는 로직 구현
        payment1.setSale(payment1.getSale());
        payment1.setCouponUse(payment1.getCouponUse());
        payment1.setPointUse(payment1.getPointUse());

        paymentRepository.save(payment1);
        return payment1;
    }
}



