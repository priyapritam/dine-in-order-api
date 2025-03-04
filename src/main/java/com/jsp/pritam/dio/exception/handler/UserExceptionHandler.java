package com.jsp.pritam.dio.exception.handler;

import com.jsp.pritam.dio.exception.UserNotFoundByIdException;
import com.jsp.pritam.dio.utility.ResponseBuilder;
import com.jsp.pritam.dio.utility.SimpleErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorResponse> handleUserNotFoundByIdException(UserNotFoundByIdException exception) {
        return ResponseBuilder.error(HttpStatus.NOT_FOUND, exception.getMessage());
    }
}
//    @ExceptionHandler(UserNotFoundByIdException.class)
//    public ResponseEntity<SimpleErrorResponse> handleUserNotFoundByIdException(UserNotFoundByIdException exception) {
//        String message = exception.getMessage() != null ? exception.getMessage() : "User not found by the given ID.";
//        return ResponseBuilder.error(HttpStatus.NOT_FOUND, message);
//    }
