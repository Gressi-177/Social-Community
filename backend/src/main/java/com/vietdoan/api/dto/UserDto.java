package com.vietdoan.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    private Integer status;

    private String role;

    private String username;

    private String imgUrl;

    /* New */
    @JsonProperty("created_at")
    private Date date02;

    /* Mod */
    @JsonProperty("updated_at")
    private Date date03;

}
