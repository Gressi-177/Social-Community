package com.vietdoan.api.service.impl;

import com.vietdoan.api.entities.Document;
import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.repository.DocumentRepository;
import com.vietdoan.api.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements com.vietdoan.api.service.PostService {
    private final PostRepository postRepository;
    private final DocumentRepository documentRepository;

    @Override
    public Page<Post> reqSVLst(
            User user,
            Integer page,
            Integer limit
    ) {
        PageRequest pageRequest = PageRequest.of(page, limit);

        return postRepository.findAll(pageRequest);
    }

    @Override
    public Post reqNew(User user, Post post) {
        post.setUser(user);
        Post ent = postRepository.save(post);
        return ent;
    }
}
