package com.vietdoan.api.config;

import com.vietdoan.api.entities.Post;
import com.vietdoan.api.repository.PostRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
@RequiredArgsConstructor
public class DatasourceConfig {
    // inject bởi RequiredArgsConstructor
    private final PostRepository postRepository;

    // Chỉ áp dụng trong demo :D
    @PostConstruct
    public void initData() {
        // Insert 100 User vào H2 Database sau khi
        // DatasourceConfig được khởi tạo
        postRepository.saveAll(IntStream.range(0, 100)
                .mapToObj(i -> Post.builder()
                        .content01("name-" + i)
                        .build())
                .collect(Collectors.toList())
        );
    }
}