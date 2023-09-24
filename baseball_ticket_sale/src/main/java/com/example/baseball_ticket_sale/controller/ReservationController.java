package com.example.baseball_ticket_sale.controller;

import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.repository.MatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ReservationController {

    @Autowired
    MatchingRepository matchingRepository;

    @GetMapping("/reservation")
    public String Reservation(Model model, @RequestParam(name = "matchId") Long matchId) {
        Matching matching = matchingRepository.findById(matchId).orElse(null);
        model.addAttribute("matching", matching);
        return "reservation/reservation";
    }

//    @GetMapping

}

