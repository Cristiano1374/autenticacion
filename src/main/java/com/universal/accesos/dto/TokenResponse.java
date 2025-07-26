package com.universal.accesos.dto;

public record TokenResponse(
        String accessToken,
        String refreshToken
) {}

/*
import com.fasterxml.jackson.annotation.JsonProperty;

public record TokenResponse(
    @JsonProperty("access_token")
    String accessToken,
    @JsonProperty("refresh_token")
    String refreshToken
) {
}
*/
