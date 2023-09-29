package com.vietdoan.api.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorResponse{
    private String status;
    private String message;
}
