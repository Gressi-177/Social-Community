package com.vietdoan.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_like")
@AllArgsConstructor
@NoArgsConstructor
public class UserLike {
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

    @Column(name = "Date_01")
    private Date date01;
}
