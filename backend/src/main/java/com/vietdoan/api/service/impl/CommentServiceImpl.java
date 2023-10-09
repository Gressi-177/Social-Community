package com.vietdoan.api.service.impl;

import com.vietdoan.api.constants.ErrorMessage;
import com.vietdoan.api.dto.CommentDto;
import com.vietdoan.api.dto.PostDto;
import com.vietdoan.api.entities.Comment;
import com.vietdoan.api.entities.Post;
import com.vietdoan.api.entities.User;
import com.vietdoan.api.exception.BadRequestException;
import com.vietdoan.api.exception.NotFoundException;
import com.vietdoan.api.repository.CommentRepository;
import com.vietdoan.api.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ModelMapper       modelMapper = new ModelMapper();

    @Override
    public CommentDto reqNew(User user, Comment comment) {
        comment.setUser(user);
        Comment ent = commentRepository.save(comment);

        CommentDto rs = modelMapper.map(ent, CommentDto.class);
        rs.setUserId(ent.getUser().getId());
        rs.setPostId(ent.getPost().getId());

        if (ent.getParent() != null) {
            rs.setParentId(ent.getParent().getId());
        }

        return rs;
    }

    @Override
    public Page<CommentDto> reqSVLst(Long postId, Integer pageNo, Integer pageSize, String sortBy) {
            if (postId ==null){
                throw new BadRequestException(ErrorMessage.BAD_REQUEST.getMessage());
            }
            pageNo = pageNo <= 0 ? 0 : pageNo - 1; // Đảm bảo pageNo không âm

            Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, sortBy));

            Page<Comment> pagedResult = commentRepository.findAllByPostId(postId, paging);

            List<CommentDto> rs = pagedResult.getContent()
                    .stream()
                    .map(comment -> modelMapper.map(comment, CommentDto.class))
                    .collect(Collectors.toList());

            return new PageImpl<>(rs, paging, pagedResult.getTotalElements());

    }
}
