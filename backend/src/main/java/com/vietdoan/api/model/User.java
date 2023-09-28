package com.vietdoan.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    @JsonProperty("_id")
    private Long id;

    @Column(name = "Status")
    @JsonProperty("status")
    private Integer status;

    @OneToOne
    @JoinColumn(name = "Id")
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.getName()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
