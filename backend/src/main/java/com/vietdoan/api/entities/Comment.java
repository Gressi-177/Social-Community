package com.vietdoan.api.entities;

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
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "date_01")
    private Date date01;

    @Column(name = "date_02")
    private Date date02;

    @PrePersist
    protected void prePersist() {
        this.date01 = new Date(System.currentTimeMillis());
        this.date02 = new Date(System.currentTimeMillis());
    }

    @PreUpdate
    protected void onUpdate() {
        this.date02 = new Date(System.currentTimeMillis());
    }
}
