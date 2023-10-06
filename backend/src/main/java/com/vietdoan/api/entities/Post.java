package com.vietdoan.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    public static final int STAT_01_NEW						= 0;
    public static final int STAT_01_ACTIVE					= 1;
    public static final int STAT_01_REVIEW					= 5;
    public static final int STAT_01_DELETED					= 10;

    public static final int	STAT_02_PRIVATE 				= 10;
    public static final int	STAT_02_PUBLIC 					= 20;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "")
    private Collection<Document> documents;

    @Column(name = "status_01")
    private Integer status_01;

    @Column(name = "status_02")
    private Integer status_02;

    @Column(name = "content_01", columnDefinition = "TEXT")
    private String content_01;

    @Column(name = "content_02", columnDefinition = "TEXT")
    private String content_02;

    @Column(name = "content_03", columnDefinition = "TEXT")
    private String content_03;

    @Column(name = "date_01")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date01;

    @Column(name = "date_02")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date02;


    @ElementCollection
    private List<Long> documentIds;
}
