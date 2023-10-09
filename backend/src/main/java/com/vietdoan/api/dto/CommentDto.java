package com.vietdoan.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDto {

    private Long id;

    private Long parentId;

    private Long userId;

    private Long postId;

    private String content;

    @JsonProperty("createAt")
    private Date date01;

    @JsonProperty("updateAt")
    private Date date02;

}
