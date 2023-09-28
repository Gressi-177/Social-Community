package com.vietdoan.api.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class APIResponse <T>{
    private String status;
    private String message;
    private T data;

}
