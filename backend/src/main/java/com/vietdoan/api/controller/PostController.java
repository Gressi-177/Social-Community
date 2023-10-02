package com.vietdoan.api.controller;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.response.APIResponse;
import com.vietdoan.api.response.ErrorResponse;
import com.vietdoan.api.response.PageableResponse;
import com.vietdoan.api.service.IPostService;
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
    private final IPostService postService;

    @PostMapping("/add")
    public ResponseEntity doSvNew(
            @RequestAttribute("userInfo")User user,
            @RequestBody Post post
    ){
        Post ent = postService.reqNew(user,post);

        if (ent == null) {
            return ResponseEntity.ok(
                    ErrorResponse
                            .builder()
                            .status(HttpStatusCode.BadRequest)
                            .message("Thêm bài viết không thành công")
                            .build()
            );
        }
        return ResponseEntity.ok(
                APIResponse
                        .builder()
                        .status(HttpStatusCode.Ok)
                        .message("Thêm bài viết thành công")
                        .data(ent)
                        .build()
        );
    }

    @GetMapping("/list")
    public ResponseEntity doSVLst(
            @RequestAttribute("userInfo")User user,
            @RequestBody Map<String, String> json
            ){
        Page<Post> rs = postService.reqSVLst(user, json);
        if (rs == null || rs.isEmpty()) {
            return ResponseEntity.ok(
                    ErrorResponse
                            .builder()
                            .status(HttpStatusCode.BadRequest)
                            .message("Lấy danh sách bài viết không thành công")
                            .build()
            );
        }
        PageableResponse pageableResponse = PageableResponse
                .builder()
                .page(rs.getNumber())
                .limit(rs.getSize())
                .pageSize(rs.getTotalPages())
                .build();
        Map<String, Object> data = new HashMap<>();
        data.put("posts", rs.getContent());
        data.put("pagination", pageableResponse);



        return ResponseEntity.ok(
                APIResponse
                        .builder()
                        .status(HttpStatusCode.Ok)
                        .message("Lấy danh sách bài viết thành công")
                        .data(data)
                        .build()
        );
    }

}
