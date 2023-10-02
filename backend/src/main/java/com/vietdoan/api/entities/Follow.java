package com.vietdoan.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;


@Data
//@Entity
@Table(name = "follow")
@AllArgsConstructor
@NoArgsConstructor
public class Follow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User_01")
    private User user01;

    @ManyToOne
    @JoinColumn(name = "User_02")
    private User user02;

    @Column(name = "Status")
    private Integer status;
}

