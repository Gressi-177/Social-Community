package com.vietdoan.api.exception;

import com.vietdoan.api.constants.HttpStatusCode;
import com.vietdoan.api.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse handleNotFoundException(NotFoundException e) {
        log.error("Resource not found: {}", e.getMessage());
        return ApiResponse.error(HttpStatusCode.NotFound, e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse handleBadRequestException(BadRequestException e) {
        log.error("Bad request: {}", e.getMessage());
        return ApiResponse.error(HttpStatusCode.BadRequest, e.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ApiResponse handleUnauthorizedException(UnauthorizedException e) {
        log.error("Unauthorized access: {}", e.getMessage());
        return ApiResponse.error(HttpStatusCode.Unauthorized, e.getMessage());
    }

    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleInternalServerErrorException(InternalServerErrorException e) {
        log.error("Internal server error: {}", e.getMessage());
        return ApiResponse.error(HttpStatusCode.InternalServerError, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleGenericException(Exception e) {
        log.error("An unexpected error occurred: {}", e.getMessage());
        return ApiResponse.error(HttpStatusCode.InternalServerError, "An unexpected error occurred");
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleMaxSizeException(MaxUploadSizeExceededException exc) {
        return ApiResponse.error(HttpStatusCode.InternalServerError, "One or more files are too large!");
    }

    @ExceptionHandler(CustomIOException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse handleIOException(CustomIOException ex) {
        return ApiResponse.error(HttpStatusCode.InternalServerError, "Failed to process the file: " + ex.getMessage());
    }
}
