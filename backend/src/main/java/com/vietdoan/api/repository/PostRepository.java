package com.vietdoan.api.repository;

import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByUser(User user, PageRequest pageRequest);
}
