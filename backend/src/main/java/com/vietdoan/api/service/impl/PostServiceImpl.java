package com.vietdoan.api.service.impl;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.dto.PostDto;
import com.vietdoan.api.dto.UserDto;
import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.exception.NotFoundException;
import com.vietdoan.api.repository.PostRepository;
import com.vietdoan.api.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository     postRepository;
    private final ModelMapper  modelMapper = new ModelMapper();


    @Override
    public Page<PostDto> reqSVLst(User user, Integer pageNo, Integer pageSize, String sortBy) {
        pageNo = pageNo <= 0 ? 0 : pageNo - 1; // Đảm bảo pageNo không âm

        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));

        Page<Post> pagedResult = postRepository.findAll(paging);

        List<PostDto> postDtos = pagedResult.getContent()
                .stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());

        return new PageImpl<>(postDtos, paging, pagedResult.getTotalElements());
    }

    @Override
    public PostDto reqNew(User user, Post post) {
        post.setUser(user);
        Post ent = postRepository.saveAndFlush(post);

        PostDto rs = modelMapper.map(ent, PostDto.class);
        rs.setUser(modelMapper.map(user, UserDto.class));
        return rs;
    }

    @Override
    public PostDto reqGet(Long id) {
        Optional<Post> postOptional = postRepository.findById(id);
        if(postOptional.isEmpty()){
            throw new NotFoundException(ErrorMessage.GET_FAILED.getMessage());
        }
        return modelMapper.map(postOptional.get(), PostDto.class);
    }

}
