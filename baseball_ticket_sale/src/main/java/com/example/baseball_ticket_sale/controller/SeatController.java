package com.example.baseball_ticket_sale.controller;

import com.example.baseball_ticket_sale.Dto.SeatDto;
import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Seat;
import com.example.baseball_ticket_sale.service.MatchingService;
import com.example.baseball_ticket_sale.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // 등급별 좌석 수 조회
    @GetMapping("/seats/byType")
    public String getSeatCounts(Model model) {
        List<Seat> seats = seatService.getAllSeats();
        model.addAttribute("seats", seats);
        return "seats";
    }

    // 등급별 좌석 수 업데이트
    @PostMapping("/seats/update")
    public String updateSeatCounts(@RequestParam String seatType, @RequestParam int newCount) {
        seatService.updateSeatCount(seatType, newCount);
        return "redirect:/seats";
    }


    // 등급별 좌석 수 조회 및 화면에 전달
    @GetMapping("/seats/{seatType}")
    public String getSeatCount(@PathVariable String seatType, Model model) {
        int seatCount = seatService.getSeatCountByType(seatType);
        model.addAttribute("seatCount", seatCount);
        return "seat_count"; // 좌석 수를 표시할 페이지로 이동
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


