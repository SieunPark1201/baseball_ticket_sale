package com.example.baseball_ticket_sale.controller;

import com.example.baseball_ticket_sale.Dto.SeatDto;
import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Seat;
import com.example.baseball_ticket_sale.service.MatchingService;
import com.example.baseball_ticket_sale.service.SeatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class SeatController {


    @Autowired
    private SeatService seatService;
    @Autowired
    private MatchingService matchingService;



   @PostMapping("/seat/reserve")
    public String reserveSeat(@RequestParam Long matchingId, SeatDto seatDto) throws Exception {
       Matching matching = matchingService.findById(matchingId);
       Seat seat = Seat.builder()
               .seatType(seatDto.getSeatType())
               .seatNumber(seatDto.getSeatNumber())
               .matching(matching)
               .build();
       seatService.create(seat);
       return "";
   }

    // 예매 가능한 좌석 조회
    @GetMapping("/available")
    public String getAvailableSeatsByType(@RequestParam("seatType") String seatType, Model model) {
        List<Seat> availableSeats = seatService.getAvailableSeatsByType(seatType);
        model.addAttribute("availableSeats", availableSeats);
        return "availableSeatList";
    }

    // 모든 좌석 조회
    @GetMapping("/all")
    public String getAllSeats(Model model) {
        List<Seat> seats = seatService.getAllSeats();
        model.addAttribute("seats", seats);
        return "seatList";
        }




    // 등급별 좌석 수 조회 및 화면에 전달
    @GetMapping("/seats")
    public String getSeatCounts(@RequestParam Matching matchingId, Model model) {
        List<String> seatTypes = List.of("S","A","B","C");

        int seatCountS = seatService.countBySeatType("S", matchingId);
        int seatCountA = seatService.countBySeatType("A", matchingId);
        int seatCountB = seatService.countBySeatType("B", matchingId);
        int seatCountC = seatService.countBySeatType("C", matchingId);


        model.addAttribute("seatTypes", seatTypes);
        model.addAttribute("seatCountS", seatCountS);
        model.addAttribute("seatCountA", seatCountA);
        model.addAttribute("seatCountB",seatCountB);
        model.addAttribute("seatCountC",seatCountC);





        return "seats";

    }


    // 예매 가능 -> 예매 불가 상태 변경
    @PostMapping("/update")
    public String updateSeatReservationStatus(@RequestParam("seatId") Long seatId, Model model) {
        try {
            SeatDto seatDto = new SeatDto();
            seatDto.setSeatId(seatId);
            Seat updatedSeat = seatService.update(seatDto);
            model.addAttribute("message", "좌석 예매 상태가 변경되었습니다.");
        } catch (Exception e) {
            model.addAttribute("error", "좌석 예매 상태 변경에 실패했습니다.");
        }
        return "redirect:/seats/all"; // 변경 후 모든 좌석 목록 페이지로 리다이렉트
    }





    }


