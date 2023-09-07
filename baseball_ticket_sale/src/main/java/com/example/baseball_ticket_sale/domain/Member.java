package com.example.baseball_ticket_sale.domain;

import com.sun.istack.NotNull;
import lombok.Builder;
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
    private Address address;

    @NotNull
    private LocalDateTime createDate;

    private int point;

    @Builder
    public Member(String email, String password, String phoneNumber, String name, String favoriteTeam, Address address, int point) {
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.favoriteTeam = favoriteTeam;
        this.address = address;
        this.point = point;
        this.createDate = LocalDateTime.now();
    }

}