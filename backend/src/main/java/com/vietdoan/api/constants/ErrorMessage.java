package com.vietdoan.api.constants;


public enum ErrorMessage {
    NOT_FOUND("Resource not found"),
    BAD_REQUEST("Bad request"),
    UNAUTHORIZED("Unauthorized access"),
    INTERNAL_SERVER_ERROR("Internal server error"),
    BAD_CREDENTIALS("Login failed: Incorrect username or password"),
    USERNAME_NOT_FOUND("Login failed: User not found"),

    ACCOUNT_EXISTS("Account already exists"),

    UNKNOWN_ERROR("Login failed: Unknown error"),
    UPLOAD_FAILED("File upload failed: An unexpected error occurred"),
    FAILED_TO_SAVE_FILE("Failed to save file"),
    ADD_FAILED("Add failed"),
    GET_LIST_FAILED("Retrieving list failed");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
