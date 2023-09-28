package com.vietdoan.api.service;


import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.model.Role;
import com.vietdoan.api.model.User;
import com.vietdoan.api.repository.RoleRepository;
import com.vietdoan.api.repository.UserRepository;
import com.vietdoan.api.request.AuthenticationRequest;
import com.vietdoan.api.request.RegisterRequest;
import com.vietdoan.api.response.APIResponse;
import com.vietdoan.api.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository        userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder       passwordEncoder;
    private final JwtService            jwtService;
    private final AuthenticationManager authenticationManager;

    public APIResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(roleRepository.findById(1L))
                .date02(new Date(System.currentTimeMillis()))
                .date03(new Date(System.currentTimeMillis()))
                .date04(new Date(System.currentTimeMillis()))
                .build();
        var  savedUser    = userRepository.save(user);
        var  jwtToken     = jwtService.generateToken(user);
        long  expiration   = jwtService.extractExpiration(jwtToken).getTime();
        var  refreshToken = jwtService.generateRefreshToken(user);
        long  refreshExpiration   = jwtService.extractExpiration(jwtToken).getTime();

        var auth = AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .expiration(expiration)
                .refreshToken(refreshToken)
                .refreshExpiration(refreshExpiration)
                .user(savedUser)
                .build();

        return APIResponse
                .builder()
                .status(HttpStatusCode.Ok)
                .message("Đăng kí thành công")
                .data(auth)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken     = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

}