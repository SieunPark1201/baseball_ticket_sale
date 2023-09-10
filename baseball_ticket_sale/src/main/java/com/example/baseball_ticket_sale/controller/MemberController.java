package com.example.baseball_ticket_sale.controller;

import com.example.baseball_ticket_sale.Dto.MemberDto;
import com.example.baseball_ticket_sale.domain.Address;
import com.example.baseball_ticket_sale.domain.Member;
import com.example.baseball_ticket_sale.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class MemberController {

    @Autowired
    MemberService memberService;



//    로그인
    @GetMapping("member/login")
    public String memberLogin(){return "members/memberLogin";}


//    회원가입
    @GetMapping("member/create")
    public String memberCreate(Model model) {
        model.addAttribute("memberForm", new MemberDto());
        return "members/createMember";
    }

    @PostMapping("member/create")
    public String memberCreate(MemberDto memberDto) throws SQLException {
        Address address = new Address(memberDto.getCity(), memberDto.getDetail(), memberDto.getZipcode());
        Member member1 = Member.builder()
                .email(memberDto.getEmail())
                .password(memberDto.getPassword())
                .phoneNumber(memberDto.getPhoneNumber())
                .name(memberDto.getName())
                .favoriteTeam(memberDto.getFavoriteTeam())
                .address(address)
                .point(memberDto.getPoint())
                .build();
        memberService.create(member1);
        return "redirect:/";
    }


//    회원정보 수정
    @PostMapping("member/update")
    public String memberUpdate(MemberDto memberDto)throws Exception {
        memberService.update(memberDto);
        return "redirect";

    }


//    회원 티켓 내역 조회




//    회원 탈퇴
    @GetMapping("member/delete")
    public String memberDelete(@RequestParam(value = "id")Long id, @RequestBody MemberDto memberDto) throws Exception {
        memberService.delete(id, memberDto);
        return "/";
    }


}


