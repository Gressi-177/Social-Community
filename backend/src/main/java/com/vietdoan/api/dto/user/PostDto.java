package com.vietdoan.api.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostDto {
    private Long id;

    private UserDto user;
    private String imgUrl;
    private Integer status_01;
    private Integer status_02;
    private String content_01;
    private String content_02;
    private String content_03;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date_01;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date_02;
}
