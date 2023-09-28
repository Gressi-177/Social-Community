package com.vietdoan.api.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vietdoan.api.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthDto {

    @JsonProperty("_id")
    private Long id;

    @JsonProperty("status")
    private Integer status;

    @JsonProperty("role")
    private String role;

    @JsonProperty("username")
    private String username;

    /* New */
    @JsonProperty("created_at")
    private Date date02;

    /* Mod */
    @JsonProperty("updated_at")
    private Date date03;

}
