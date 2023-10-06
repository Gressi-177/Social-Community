package com.vietdoan.api.service;

import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<Post> reqSVLst(User user, Integer page, Integer limit);

    Post reqNew(User user, Post post);
}
