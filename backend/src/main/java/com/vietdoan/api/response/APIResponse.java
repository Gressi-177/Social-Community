package com.vietdoan.api.response;


public class APIResponse {
    private String status;
    private String message;
    private Object data;

    public APIResponse(String status, String message, Object data) {
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

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public Object getData() {
        return data;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
