package com.vietdoan.api.service;


import com.vietdoan.api.request.AuthenticationRequest;
import com.vietdoan.api.request.RegisterRequest;
import com.vietdoan.api.response.ApiResponse;

public interface AuthenticationService {

    ApiResponse register(RegisterRequest request);

    ApiResponse authenticate(AuthenticationRequest request);

    ApiResponse refreshToken(String refreshToken);

}