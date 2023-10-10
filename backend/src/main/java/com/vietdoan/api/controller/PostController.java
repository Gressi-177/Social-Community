package com.vietdoan.api.controller;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.constants.SuccessMessage;
import com.vietdoan.api.dto.PostDto;
import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.exception.NotFoundException;
import com.vietdoan.api.response.ApiResponse;
import com.vietdoan.api.response.PageableResponse;
import com.vietdoan.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> doNew(
            @RequestAttribute("userInfo")User user,
            @RequestBody Post post
    ){

        PostDto ent = postService.reqNew(user, post);

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
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "date01") String sortBy
            ){
        Page<PostDto> rs = postService.reqSVLst(null, pageNo, pageSize, sortBy);
        if (rs == null || rs.isEmpty()) {
            throw new NotFoundException(ErrorMessage.GET_LIST_FAILED.getMessage());
        }
        PageableResponse pageableResponse = PageableResponse
                .builder()
                .page(rs.getNumber()+1)
                .limit(rs.getSize())
                .pageSize(rs.getTotalPages())
                .build();

        Map<String, Object> data = new HashMap<>();
        data.put("posts", rs.getContent());
        data.put("pagination", pageableResponse);

        return ResponseEntity.ok(
                ApiResponse.success(HttpStatusCode.Ok, SuccessMessage.GET_LIST_SUCCESS.getMessage(), data)
        );
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ApiResponse> doGet(@PathVariable(name = "postId") Long postId){
        PostDto ent = postService.reqGet(postId);
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
