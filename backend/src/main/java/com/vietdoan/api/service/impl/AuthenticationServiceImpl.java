package com.vietdoan.api.service.impl;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.constants.SuccessMessage;
import com.vietdoan.api.dto.user.UserDto;
import com.vietdoan.api.entities.Role;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.exception.InternalServerErrorException;
import com.vietdoan.api.exception.NotFoundException;
import com.vietdoan.api.exception.UnauthorizedException;
import com.vietdoan.api.repository.UserRepository;
import com.vietdoan.api.request.AuthenticationRequest;
import com.vietdoan.api.request.RegisterRequest;
import com.vietdoan.api.response.ApiResponse;
import com.vietdoan.api.response.AuthenticationResponse;
import com.vietdoan.api.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements com.vietdoan.api.service.AuthenticationService {
    private final UserRepository        userRepository;
    private final PasswordEncoder       passwordEncoder;
    private final JwtService            jwtService;
    private final AuthenticationManager authenticationManager;
    private final ModelMapper           modelMapper = new ModelMapper();



    public ApiResponse register(RegisterRequest request) {
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
            return ApiResponse
                    .error(HttpStatusCode.BadRequest, ErrorMessage.ACCOUNT_EXISTS.getMessage());
        }
        User savedUser = userRepository.save(user);

        var     jwtToken  = jwtService.generateToken(user);
        var  refreshToken      = jwtService.generateRefreshToken(user);

        var authRes = AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(modelMapper.map(savedUser, UserDto.class))
                .build();

        return ApiResponse.success(
                HttpStatusCode.Ok,
                SuccessMessage.REGISTRATION_SUCCESS.getMessage(),
                authRes
        );
    }

    public ApiResponse authenticate(AuthenticationRequest request) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()
                    )
            );

            var user = userRepository
                    .findByUsername(request.getUsername())
                    .orElseThrow(() -> new NotFoundException(ErrorMessage.USERNAME_NOT_FOUND.getMessage()));

            var jwtToken = jwtService.generateToken(user);
            var refreshToken = jwtService.generateRefreshToken(user);

            var authRes = AuthenticationResponse.builder()
                    .accessToken(jwtToken)
                    .refreshToken(refreshToken)
                    .user(modelMapper.map(user, UserDto.class))
                    .build();
            return ApiResponse.success(
                    HttpStatusCode.Ok,
                    SuccessMessage.LOGIN_SUCCESS.getMessage(),
                    authRes
            );
        } catch (BadCredentialsException ex) {
            throw new UnauthorizedException(ErrorMessage.BAD_CREDENTIALS.getMessage());
        } catch (UsernameNotFoundException ex) {
            throw new NotFoundException(ErrorMessage.USERNAME_NOT_FOUND.getMessage());
        } catch (Exception ex) {
            throw new InternalServerErrorException(ErrorMessage.INTERNAL_SERVER_ERROR.getMessage());
        }
    }

    @Override
    public ApiResponse refreshToken(
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

                return ApiResponse
                        .builder()
                        .status(HttpStatusCode.Ok)
                        .data(authResponse)
                        .build();
            }
        }
        return ApiResponse
                .builder()
                .status(HttpStatusCode.Unauthorized)
                .message("Token không hợp lệ")
                .build();
    }

}
