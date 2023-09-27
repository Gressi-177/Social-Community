package com.vietdoan.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Status")
    private Integer status;

    @OneToOne
    @JoinColumn(name = "Id")
    private Role role;

    @Column(name = "Username", length = 100)
    private String username;

    @Column(name = "Password", length = 1000)
    private String password;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "Date_01")
    private Date date01;

    @Column(name = "Date_02")
    private Date date02;

    @Column(name = "Date_03")
    private Date date03;

    @Column(name = "Date_04")
    private Date date04;

}
