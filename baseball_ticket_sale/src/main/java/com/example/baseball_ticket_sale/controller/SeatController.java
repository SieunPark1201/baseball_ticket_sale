package com.example.baseball_ticket_sale.controller;

import com.example.baseball_ticket_sale.Dto.SeatDto;
import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Seat;
import com.example.baseball_ticket_sale.service.MatchingService;
import com.example.baseball_ticket_sale.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
