package com.example.baseball_ticket_sale.Dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {
    private Long id;
    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    private String favoriteTeam;

    private String city;

    private String detail;

    private String zipcode;
    private LocalDateTime createDate;
    private int point;
}
