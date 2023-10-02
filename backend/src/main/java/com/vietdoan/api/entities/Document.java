package com.vietdoan.api.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "document")
@AllArgsConstructor
@NoArgsConstructor
public class Document {

    public static final  Integer TYPE_DOCUMENT_POST = 1000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "entity_id")
    private Long entity_id;

    @Column(name = "type_01")
    private Integer type01;

    @Column(name = "type_02")
    private Integer type02;

    @Column(name = "info_01", columnDefinition = "TEXT")
    private String info_01;

    @Column(name = "info_02", columnDefinition = "TEXT")
    private String info_02;

    @Column(name = "date_01")
    private Date date01;

    @Column(name = "date_02")
    private Date date02;
}
