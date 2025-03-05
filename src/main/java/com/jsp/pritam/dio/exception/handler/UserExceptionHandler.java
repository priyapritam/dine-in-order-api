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

    /**
     * Handles the {@link UserNotFoundByIdException} by returning a standardized error response.
     * This method is invoked when a {@link UserNotFoundByIdException} is thrown in the application,
     * providing a "Not Found" HTTP response with an appropriate error message.
     *
     * @param exception the exception instance containing details about the user not found error
     * @return a {@link ResponseEntity} containing a {@link SimpleErrorResponse} with a 404 status and error message
     */
    @ExceptionHandler(UserNotFoundByIdException.class)
    public ResponseEntity<SimpleErrorResponse> handleUserNotFoundByIdException(UserNotFoundByIdException exception) {
        return ResponseBuilder.notFound(exception.getMessage());
    }
}
//    @ExceptionHandler(UserNotFoundByIdException.class)
//    public ResponseEntity<SimpleErrorResponse> handleUserNotFoundByIdException(UserNotFoundByIdException exception) {
//        String message = exception.getMessage() != null ? exception.getMessage() : "User not found by the given ID.";
//        return ResponseBuilder.error(HttpStatus.NOT_FOUND, message);
//    }
