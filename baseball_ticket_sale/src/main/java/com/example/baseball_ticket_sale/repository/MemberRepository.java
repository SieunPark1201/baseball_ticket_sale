package com.example.baseball_ticket_sale.repository;

import com.example.baseball_ticket_sale.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
