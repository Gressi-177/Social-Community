package com.vietdoan.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vietdoan.api.dto.user.UserAuthDto;
import com.vietdoan.api.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("user")
    private UserAuthDto user;
}
