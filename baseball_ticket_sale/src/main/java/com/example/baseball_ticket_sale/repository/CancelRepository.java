package com.example.baseball_ticket_sale.repository;

import com.example.baseball_ticket_sale.domain.Cancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelRepository extends JpaRepository<Cancel,Long> {
}
