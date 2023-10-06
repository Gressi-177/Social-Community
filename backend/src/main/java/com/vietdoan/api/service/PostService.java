package com.vietdoan.api.service;

import com.vietdoan.api.dto.user.PostDto;
import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<PostDto> reqSVLst(User user, Integer page, Integer limit);
    PostDto reqNew(User user, Post post);

}
