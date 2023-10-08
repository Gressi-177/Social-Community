package com.vietdoan.api.constants;

public enum SuccessMessage {
    LOGIN_SUCCESS("Login successful"),
    REGISTRATION_SUCCESS("Registration successful"),
    UPDATE_SUCCESS("Update successful"),
    DELETE_SUCCESS("Delete successful"),
    UPLOAD_SUCCESS("Upload successful"),
    ADD_SUCCESS("Add successful"),
    GET_LIST_SUCCESS("Get list successfully");

    private final String message;

    SuccessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
