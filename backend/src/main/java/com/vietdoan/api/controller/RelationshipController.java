package com.vietdoan.api.controller;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.constants.SuccessMessage;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.exception.NotFoundException;
import com.vietdoan.api.response.ApiResponse;
import com.vietdoan.api.service.RelationshipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RelationshipController {
    private final RelationshipService service;

    @PostMapping("/friends")
    public ResponseEntity<ApiResponse> doSVLst(@RequestAttribute("userInfo")User user, @RequestBody Map<String, String> json) {
        List<User> list = service.reqSVLst(user, json);
        if (list == null || list.isEmpty()) {
            throw new NotFoundException(ErrorMessage.GET_LIST_FAILED.getMessage());
        }
        return ResponseEntity.ok(
                ApiResponse.success(HttpStatusCode.Ok, SuccessMessage.GET_LIST_SUCCESS.getMessage(), list)
        );
    }
}
