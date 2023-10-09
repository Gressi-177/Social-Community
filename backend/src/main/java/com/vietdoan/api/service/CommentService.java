package com.vietdoan.api.service;

import com.vietdoan.api.dto.CommentDto;
import com.vietdoan.api.dto.PostDto;
import com.vietdoan.api.entities.Comment;
import com.vietdoan.api.entities.User;
import org.springframework.data.domain.Page;

public interface CommentService {
    public CommentDto reqNew(User user, Comment comment);
    Page<CommentDto> reqSVLst(Long postId, Integer pageNo, Integer pageSize, String sortBy);

}
