package com.example.baseball_ticket_sale.repository;

import com.example.baseball_ticket_sale.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
}
