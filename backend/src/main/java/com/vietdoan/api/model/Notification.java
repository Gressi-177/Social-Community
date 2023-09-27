package com.vietdoan.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "notification")
@AllArgsConstructor
@NoArgsConstructor
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @Column(name = "Type")
    private Integer type;

    @Column(name = "Content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Date")
    private Date date;
}
