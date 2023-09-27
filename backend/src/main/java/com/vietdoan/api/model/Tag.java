package com.vietdoan.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tag")
@AllArgsConstructor
@NoArgsConstructor
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "Name", length = 100, unique = true)
    private String name;

    @Column(name = "Date_01")
    private Date date01;

    @Column(name = "Date_02")
    private Date date02;

}
