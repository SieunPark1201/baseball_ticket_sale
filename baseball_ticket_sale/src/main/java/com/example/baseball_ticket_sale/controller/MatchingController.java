package com.example.baseball_ticket_sale.controller;

import com.example.baseball_ticket_sale.Dto.MatchingDto;
import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.domain.Stadium;
import com.example.baseball_ticket_sale.domain.Team;
import com.example.baseball_ticket_sale.repository.MatchingRepository;
import com.example.baseball_ticket_sale.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
public class MatchingController {

    @Autowired
    MatchingService matchingService;


//    홈화면
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("teams", Team.values());
        model.addAttribute("stadiums", Stadium.values());
        List<Matching> matchingList = matchingService.findAll();
        model.addAttribute("matchingList", matchingList);
        return "home";
    }

//    목록 조회
    @GetMapping("/match/lists")
    public String postFindAll(Model model){
        List<Matching> matches = matchingService.findAll();
        model.addAttribute("matchingList",matches);
        return "matching/matchingList";
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

//    경기 등록
    @GetMapping("/match/create")
    public String createMatch(Model model) {
        model.addAttribute("newMatch", new MatchingDto());

        return "matching/createMatch";
    }

    @PostMapping("/match/create")
    public String createMatch(MatchingDto matchingDto, Model model) throws Exception {
        Matching matching = Matching.builder()
                .matchDayAndTime(matchingDto.getMatchDayAndTime())
                .homeTeam(matchingDto.getHomeTeam())
                .awayTeam(matchingDto.getAwayTeam())
                .stadium(matchingDto.getStadium())
                .build();
        matchingService.create(matching);
//        String message = "등록 되었습니다!";
//        model.addAttribute("message", message);
        return "redirect:/match/create";
    }

//   경기 취소
    @GetMapping("/match/delete/{myId}")
    public String deleteMatch(@PathVariable Long myId) {
        matchingService.delete(myId);
        return "redirect:/match/lists";
    }

}
