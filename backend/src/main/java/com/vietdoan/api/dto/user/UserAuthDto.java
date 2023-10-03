package com.vietdoan.api.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vietdoan.api.entities.Role;
import com.vietdoan.api.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
