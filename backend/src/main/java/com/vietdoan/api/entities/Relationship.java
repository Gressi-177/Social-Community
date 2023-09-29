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
    @Column(name = "Id")
    private Long id;

    @ManyToMany
    @JoinColumn(name = "Id")
    private Collection<User> user01;

    @ManyToMany
    @JoinColumn(name = "Id")
    private Collection<User> user02;

    @Column(name = "Status")
    private Integer status;
}
