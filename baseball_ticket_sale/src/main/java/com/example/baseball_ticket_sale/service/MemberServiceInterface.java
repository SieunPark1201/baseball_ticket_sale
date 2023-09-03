package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.Dto.MemberDto;
import com.example.baseball_ticket_sale.domain.Member;

public interface MemberServiceInterface {
    Member updateUserProfile(Long id, MemberDto memberDto);
}
