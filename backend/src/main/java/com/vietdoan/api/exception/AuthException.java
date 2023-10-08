package com.vietdoan.api.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.response.ApiResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthException implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        ApiResponse errorResponse = ApiResponse.error(HttpStatusCode.Unauthorized,"Unauthorized");

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType("application/json");
        ObjectMapper objectMapper = new ObjectMapper();
        try (OutputStream out = response.getOutputStream()) {
            objectMapper.writeValue(out, errorResponse);
        }
    }
}
