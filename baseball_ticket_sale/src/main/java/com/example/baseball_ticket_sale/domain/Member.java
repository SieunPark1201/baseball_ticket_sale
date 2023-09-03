package com.example.baseball_ticket_sale.domain;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    @Column(length= 50, unique = true)
    private String email;

    @NotNull
    @Column(length = 30)
    private String password;

    @NotNull
    @Column(length = 30)
    private String phoneNumber;

    @NotNull
    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String favoriteTeam;

    @Embedded
    private String address;

    @NotNull
    private LocalDateTime createDate;

    private int point;

}