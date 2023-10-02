package com.vietdoan.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
//@Entity
@Table(name = "post_tag")
@AllArgsConstructor
@NoArgsConstructor
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "Tag")
    private Tag tag;
}
