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

    @Column(unique = true)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String phoneNumber;

    @NotNull
    private String name;

    private String favoriteTeam;

    @Embedded
    private String address;

    @NotNull
    private LocalDateTime createDate;

    private int point;

}
