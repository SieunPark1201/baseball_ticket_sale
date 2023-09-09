package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.Dto.MemberDto;
import com.example.baseball_ticket_sale.domain.Member;
import com.example.baseball_ticket_sale.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


//    회원가입
    public void create(Member member) {
        memberRepository.save(member);
    }



//    회원수정
    @Transactional
    public Member update(MemberDto memberDto) throws Exception {
        Member member1 = memberRepository.findById(Long.parseLong(Integer.toString(memberDto.getId())))
                .orElseThrow(Exception::new);

        // memberDTO로부터 업데이트할 정보를 추출하여 기존 사용자 정보를 업데이트
        member1.setEmail(memberDto.getEmail());
        member1.setPassword(memberDto.getPassword());
        member1.setPhoneNumber(member1.getPhoneNumber());
        member1.setName(memberDto.getName());
        member1.setFavoriteTeam(member1.getFavoriteTeam());
        member1.setAddress(member1.getAddress());

        // 데이터베이스에 업데이트된 사용자 정보를 저장
        Member updatedMember = memberRepository.save(member1);

        return updatedMember;
    }


//    회원탈퇴
    public void delete(Long id, MemberDto memberDto) {
        Member member1= memberRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

    }


}


