package com.vietdoan.api.service;

import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface IPostService{
    Page<Post> reqSVLst(User user, Map<String, String> json);
}
