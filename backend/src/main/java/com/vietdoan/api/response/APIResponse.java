package com.vietdoan.api.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class APIResponse <T>{
    private String status;
    private String message;
    private T data;

    public APIResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public APIResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public APIResponse() {

    }

}
