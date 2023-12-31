package com.vietdoan.api.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private User user;

    @OneToMany(mappedBy = "post")
    private Collection<Comment> comments;

    @Column(name = "img_Url")
    private String imgUrl;

    @Column(name = "status_01")
    private Integer status01;

    @Column(name = "status_02")
    private Integer status02;

    @Column(name = "content_01", columnDefinition = "TEXT")
    private String content01;

    @Column(name = "content_02", columnDefinition = "TEXT")
    private String content02;

    @Column(name = "content_03", columnDefinition = "TEXT")
    private String content03;

    @Column(name = "date_01")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date01;

    @Column(name = "date_02")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
