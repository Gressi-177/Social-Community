package com.vietdoan.api.response;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class PageableResponse{
    private Integer page;
    private Integer limit;

    private Integer pageSize;
}
