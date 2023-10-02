package com.vietdoan.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Collection;


@Data
@Entity
@Table(name = "relationship")
@AllArgsConstructor
@NoArgsConstructor
public class Relationship {
    public static final int STATUS_PENDING = 0;
    public static final int STATUS_ACCEPTED = 1;
    public static final int STATUS_REJECTED = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_01")
    private User user_01;

    @ManyToOne
    @JoinColumn(name = "user_02")
    private User user_02;

    @Column(name = "status")
    private Integer status;
}
