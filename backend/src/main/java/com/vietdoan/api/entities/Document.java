package com.vietdoan.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "document")
@AllArgsConstructor
@NoArgsConstructor
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Post")
    private Post post;

    @Column(name = "Type_01")
    private Integer type01;

    @Column(name = "Type_02")
    private Integer type02;

    @Column(name = "Info", columnDefinition = "TEXT")
    private String info;

    @Column(name = "Date_01")
    private Date date01;

    @Column(name = "Date_02")
    private Date date02;
}
