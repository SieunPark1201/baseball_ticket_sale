package com.example.baseball_ticket_sale.controller;

import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Stadium;
import com.example.baseball_ticket_sale.domain.Team;
import com.example.baseball_ticket_sale.repository.MatchingRepository;
import com.example.baseball_ticket_sale.service.MatchingService;
import net.bytebuddy.asm.MemberSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class MatchingController {

    @Autowired
    MatchingRepository matchingRepository;
    @Autowired
    MatchingService matchingService;


//    홈화면
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("teams", Team.values());
        model.addAttribute("stadiums", Stadium.values());
        return "home";
    }

//    목록 조회
    @GetMapping("/lists")
    public String postFindAll(Model model){
        List<Matching> matches = matchingService.findAll();
        model.addAttribute("matchingList",matches);
        return "home";
    }

//    구단명 검색 조회
    @GetMapping("/lists/stadium")
    public String matchingFindByStadium(@RequestParam(value = "stadium")String myStadium, Model model) throws EntityNotFoundException {
        List<Matching> matchingOfStadium = matchingService.findByStadium(myStadium);
        model.addAttribute("matching", matchingOfStadium);
        return "home";
    }


//    경기장명 검색 조회
    @GetMapping("/lists/team")
    public String matchingFindByTeam(@RequestParam(value = "team")String myTeam, Model model) throws EntityNotFoundException {
        List<Matching> matchingOfTeam = matchingService.findByTeam(myTeam);
        model.addAttribute("matching", matchingOfTeam);
        return "home";
}




}
