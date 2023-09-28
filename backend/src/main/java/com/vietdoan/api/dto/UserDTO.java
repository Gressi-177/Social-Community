package com.vietdoan.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vietdoan.api.model.Role;
import jakarta.persistence.*;

import java.util.Date;

public class UserDTO {

    @JsonProperty("_id")
    private Long id;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("role")
    private Role role;

    @Column(name = "Username", length = 100)
    @JsonProperty("username")
    private String username;

    @Column(name = "Password", length = 1000)
    @JsonIgnore
    private String password;

    @Column(name = "Email", length = 50)
    @JsonProperty("email")
    private String email;

    /* Birth Date */
    @Column(name = "Date_01")
    @JsonProperty("birth_date")
    private Date date01;

    /* New */
    @Column(name = "Date_02")
    @JsonProperty("created_at")
    private Date date02;

    /* Mod */
    @Column(name = "Date_03")
    @JsonProperty("updated_at")
    private Date date03;

    /* Last login */
    @Column(name = "Date_04")
    @JsonProperty("login_at")
    private Date date04;
}
