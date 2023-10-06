package com.vietdoan.api.controller;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.response.APIResponse;
import com.vietdoan.api.response.ErrorResponse;
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
    public ResponseEntity doSVLst(@RequestAttribute("userInfo")User user, @RequestBody Map<String, String> json) {
        List<User> list = service.reqSVLst(user, json);
        if (list == null || list.size() == 0) {
            return ResponseEntity.ok(
                    ErrorResponse
                            .builder()
                            .status(HttpStatusCode.BadRequest)
                            .message("Lấy danh sách bạn bè không thành công")
                            .build()
            );
        }
        return ResponseEntity.ok(
                APIResponse
                        .builder()
                        .status(HttpStatusCode.Ok)
                        .data(list)
                        .build()
        );
    }
}
