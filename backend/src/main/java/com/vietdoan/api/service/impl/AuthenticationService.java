package com.vietdoan.api.service.impl;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.dto.user.UserAuthDto;
import com.vietdoan.api.entities.Role;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.repository.UserRepository;
import com.vietdoan.api.request.AuthenticationRequest;
import com.vietdoan.api.request.RegisterRequest;
import com.vietdoan.api.response.APIResponse;
import com.vietdoan.api.response.AuthenticationResponse;
import com.vietdoan.api.service.IAuthenticationService;
import com.vietdoan.api.service.IJwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements IAuthenticationService {
    private final UserRepository        userRepository;
    private final PasswordEncoder       passwordEncoder;
    private final IJwtService           jwtService;
    private final AuthenticationManager authenticationManager;

    public APIResponse register(RegisterRequest request) {
        var user = User.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .status(User.STAT_ACTIVE)
                .role(Role.USER)
                .date02(new Date(System.currentTimeMillis()))
                .date03(new Date(System.currentTimeMillis()))
                .date04(new Date(System.currentTimeMillis()))
                .build();

        if (userRepository.existsByUsername(user.getUsername())) {
            return APIResponse
                    .builder()
                    .status(HttpStatusCode.BadRequest)
                    .message("Tài khoản đã tồn tại")
                    .build();
        }
        User savedUser = userRepository.save(user);

        var     jwtToken  = jwtService.generateToken(user);
        var  refreshToken      = jwtService.generateRefreshToken(user);

        var authRes = AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(UserAuthDto.convertToDto(savedUser))
                .build();

        return APIResponse
                .builder()
                .status(HttpStatusCode.Ok)
                .message("Đăng kí thành công")
                .data(authRes)
                .build();
    }

    public APIResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository
                .findByUsername(request.getUsername())
                .orElseThrow();
        var jwtToken     = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);

        var authRes = AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(UserAuthDto.convertToDto(user))
                .build();

        return APIResponse
                .builder()
                .status(HttpStatusCode.Ok)
                .message("Đăng nhập thành công")
                .data(authRes)
                .build();
    }

    @Override
    public APIResponse refreshToken(
            String refreshToken
    ) {
        String userName = jwtService.extractUsername(refreshToken);
        if (userName != null) {
            var user = userRepository.findByUsername(userName)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();

                return APIResponse
                        .builder()
                        .status(HttpStatusCode.Ok)
                        .data(authResponse)
                        .build();
            }
        }
        return APIResponse
                .builder()
                .status(HttpStatusCode.Unauthorized)
                .message("Token không hợp lệ")
                .build();
    }


}
