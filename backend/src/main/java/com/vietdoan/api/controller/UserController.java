package com.vietdoan.api.controller;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.constants.SuccessMessage;
import com.vietdoan.api.dto.UserDto;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.response.ApiResponse;
import com.vietdoan.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController()
@RequestMapping("/api/v1")
public class UserController {
    private final UserService userService;
    @GetMapping("/profile")
    public ResponseEntity<ApiResponse> doGetProfile( @RequestAttribute("userInfo")User user){
        UserDto ent = userService.reqGetProfile(user);
        return ResponseEntity.ok(
                ApiResponse
                        .success
                                (
                                        HttpStatusCode.Ok,
                                        SuccessMessage.GET_SUCCESS.getMessage(),
                                        ent
                                )
        );
    }
}
