package com.vietdoan.api.entities;

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
    public static final int		STAT_INACTIVE 		= 0;
    public static final int		STAT_ACTIVE 		= 1;
    public static final int		STAT_WAITING 		= 2;
    public static final int		STAT_DELETED 		= 10;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("_id")
    private Long id;

    @Column(name = "status")
    @JsonProperty("status")
    private Integer status;

    @Column(name = "role")
    @JsonProperty("role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "username", length = 100, unique = true)
    @JsonProperty("username")
    private String username;

    @Column(name = "password", length = 1000)
    @JsonIgnore
    private String password;

    @Column(name = "email", length = 50)
    @JsonProperty("email")
    private String email;

    /* Birth Date */
    @Column(name = "date_01")
    @JsonProperty("birth_date")
    private Date date01;

    /* New */
    @Column(name = "date_02")
    @JsonProperty("created_at")
    private Date date02;

    /* Mod */
    @Column(name = "date_03")
    @JsonProperty("updated_at")
    private Date date03;

    /* Last login */
    @Column(name = "date_04")
    @JsonProperty("login_at")
    private Date date04;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    @JsonIgnore
    private Collection<Post> posts;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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
