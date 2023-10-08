package com.vietdoan.api.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse{
    private String status;
    private String message;
    private Object data;

    public static ApiResponse success(String status, String message, Object data) {
        return ApiResponse.builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }

    public static ApiResponse error(String status, String message) {
        return ApiResponse.builder()
                .status(status)
                .message(message)
                .data(null)
                .build();
    }
}
