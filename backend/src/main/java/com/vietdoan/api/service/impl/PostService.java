package com.vietdoan.api.service.impl;

import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.repository.PostRepository;
import com.vietdoan.api.service.IPostService;
import com.vietdoan.api.utils.ToolData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private final PostRepository postRepository;

    @Override
    public Page<Post> reqSVLst(User user,
                               Map<String, String> json
    ) {
        Integer     page        = ToolData.reqInt(json, "page", 0);
        Integer     limit       = ToolData.reqInt(json, "limit", 0);
        PageRequest pageRequest = PageRequest.of(page, limit);

        return postRepository.findAll(pageRequest);
    }
}
