package com.vietdoan.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vietdoan.api.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expiration")
    private long expiration;

    @JsonProperty("refresh_token")
    private String refreshToken;

    @JsonProperty("refresh_expiration")
    private long refreshExpiration;

    @JsonProperty("user")
    private User user;
}
