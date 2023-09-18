package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.domain.Matching;
import com.example.baseball_ticket_sale.repository.MatchingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class MatchingService {

    @Autowired
    MatchingRepository matchingRepository;

//    경기 등록
    public void create(Matching matching) throws Exception {
        matchingRepository.save(matching);
    }



//    경기 조회
    public List<Matching> findAll() {
        List<Matching> matchingList = matchingRepository.findAll();
        return matchingList;
    }



//    경기 팀으로 조회
    public List<Matching> findByTeam(String team) {
        List<Matching> matchinglistForTeam = matchingRepository.findByHomeTeamOrAwayTeam(team, team);

        if (matchinglistForTeam.isEmpty()) {
            throw new EntityNotFoundException(team + "의 경기가 없습니다");
        }

        return matchinglistForTeam;
    }


//    경기 팀으로 조회
    public List<Matching> findByStadium(String stadium) {
        List<Matching> matchinglistForStadium = matchingRepository.findByStadium(stadium);

        if (matchinglistForStadium.isEmpty()) {
            throw new EntityNotFoundException(stadium + "에서 열리는 경기가 없습니다");
        }

        return matchinglistForStadium;
    }

    public Matching findById(Long myId) {
        return matchingRepository.findById(myId).orElse(null);
    }

//    경기 상태 변경

    public void delete(Long myId) {
        Matching matching = matchingRepository.findById(myId).orElse(null);
        matchingRepository.delete(matching);
    }

    }