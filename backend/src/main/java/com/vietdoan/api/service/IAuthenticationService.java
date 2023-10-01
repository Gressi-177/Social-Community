package com.vietdoan.api.service;


import com.vietdoan.api.request.AuthenticationRequest;
import com.vietdoan.api.request.RegisterRequest;
import com.vietdoan.api.response.APIResponse;

public interface IAuthenticationService {

    APIResponse register(RegisterRequest request);

    APIResponse authenticate(AuthenticationRequest request);

    APIResponse refreshToken(String refreshToken);

}