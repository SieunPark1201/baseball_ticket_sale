package com.example.baseball_ticket_sale.Dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberDto {
    private int id;
    private String email;
    private String password;
    private String phoneNumber;
    private String name;
    private String favoriteTeam;

    private String address;
    private LocalDateTime createDate;
    private int point;
}
