package com.vietdoan.api.repository;

import com.vietdoan.api.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
