package com.vietdoan.api.controller;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.model.Role;
import com.vietdoan.api.repository.RoleRepository;
import com.vietdoan.api.response.APIResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    public final RoleRepository repository;

    public RoleController(RoleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/role")
    public ResponseEntity<APIResponse> getRoles() {
        List<Role> roles = repository.findAll();
        return ResponseEntity.ok().body(
                new APIResponse(HttpStatusCode.Ok, "Ok", roles)
        );
    }
}
