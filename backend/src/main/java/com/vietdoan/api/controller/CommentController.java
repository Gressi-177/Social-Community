package com.vietdoan.api.controller;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.constants.SuccessMessage;
import com.vietdoan.api.dto.CommentDto;
import com.vietdoan.api.dto.PostDto;
import com.vietdoan.api.entities.Comment;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.exception.NotFoundException;
import com.vietdoan.api.response.ApiResponse;
import com.vietdoan.api.response.PageableResponse;
import com.vietdoan.api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> doNew(
            @RequestAttribute("userInfo") User user,
            @RequestBody Comment comment
    ) {

        CommentDto ent = commentService.reqNew(user, comment);
        if (ent == null) {
            throw new NotFoundException(ErrorMessage.ADD_FAILED.getMessage());
        }
        return ResponseEntity.ok(
                ApiResponse
                        .success
                                (
                                        HttpStatusCode.Ok,
                                        SuccessMessage.ADD_SUCCESS.getMessage(),
                                        ent
                                )
        );

    }

    @GetMapping("/list")
    public ResponseEntity<ApiResponse> doLst(
            @RequestParam Long postId,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "date01") String sortBy
    ) {
        Page<CommentDto> rs = commentService.reqSVLst(postId, pageNo, pageSize, sortBy);
        if (rs == null || rs.isEmpty()) {
            throw new NotFoundException(ErrorMessage.GET_LIST_FAILED.getMessage());
        }
        PageableResponse pageableResponse = PageableResponse
                .builder()
                .page(rs.getNumber() + 1)
                .limit(rs.getSize())
                .pageSize(rs.getTotalPages())
                .build();

        Map<String, Object> data = new HashMap<>();
        data.put("comments", rs.getContent());
        data.put("pagination", pageableResponse);

        return ResponseEntity.ok(
                ApiResponse.success(HttpStatusCode.Ok, SuccessMessage.GET_LIST_SUCCESS.getMessage(), data)
        );
    }

}
