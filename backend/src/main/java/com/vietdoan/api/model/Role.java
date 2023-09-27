package com.vietdoan.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "role")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("_id")
    private Long id;

    @Column(name = "Status")
    @JsonProperty("status")
    private Integer status;

    @Column(name = "Name")
    @JsonProperty("name")
    private String name;

    @Column(name = "Info_01", columnDefinition = "TEXT")
    @JsonProperty("info_01")
    private String info01;

    @Column(name = "Info_02", columnDefinition = "TEXT")
    @JsonProperty("info_02")
    private String info02;

}

