package com.vietdoan.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @Column(name = "Type")
    private Integer type;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Content_01", columnDefinition = "TEXT")
    private String content01;

    @Column(name = "Content_02", columnDefinition = "TEXT")
    private String content02;

    @Column(name = "Content_03", columnDefinition = "TEXT")
    private String content03;

    @Column(name = "Date_01")
    private Date date01;

    @Column(name = "Date_02")
    private Date date02;
}
