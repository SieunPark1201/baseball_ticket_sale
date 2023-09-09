package com.example.baseball_ticket_sale.repository;

import com.example.baseball_ticket_sale.domain.Matching;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchingRepository extends JpaRepository<Matching, Long> {
    List<Matching> findByHomeTeamOrAwayTeam(String team, String team1);

    List<Matching> findByStadium(String stadium);
}
