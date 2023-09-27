package com.vietdoan.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@Table(name = "comment")
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Parent")
    private Comment parent;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Post")
    private Post post;

    @Column(name = "Content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "Date_01")
    private Date date01;

    @Column(name = "Date_02")
    private Date date02;
}
