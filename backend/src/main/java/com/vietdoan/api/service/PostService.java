package com.vietdoan.api.service;

import com.vietdoan.api.dto.PostDto;
import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import org.springframework.data.domain.Page;

public interface PostService {
    Page<PostDto> reqSVLst(User user,Integer pageNo, Integer pageSize, String sortBy);
    PostDto reqNew(User user, Post post);
    PostDto reqGet(Long id);


}
