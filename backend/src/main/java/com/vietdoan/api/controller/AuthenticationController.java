package com.vietdoan.api.controller;

import com.vietdoan.api.dto.user.UserAuthDto;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.request.AuthenticationRequest;
import com.vietdoan.api.request.RegisterRequest;
import com.vietdoan.api.service.IAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final IAuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refreshToken")
    public ResponseEntity refreshToken(
            @RequestBody String refreshToken
    ) {
        return ResponseEntity.ok(service.refreshToken(refreshToken));
    }


}