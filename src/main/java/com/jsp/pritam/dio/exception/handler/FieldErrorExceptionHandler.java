package com.jsp.pritam.dio.exception.handler;

import com.jsp.pritam.dio.utility.FieldErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class FieldErrorExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        List<FieldErrorResponse.FieldError> errors = new ArrayList<>();
        List<ObjectError> objectErrors = ex.getAllErrors();
        for (ObjectError objectError : objectErrors) {
            if (objectError instanceof FieldError) {
                FieldError fieldError = (FieldError) objectError;
                FieldErrorResponse.FieldError error = FieldErrorResponse.fieldError(
                        fieldError.getDefaultMessage(),
                        fieldError.getRejectedValue(),
                        fieldError.getField()
                );
                errors.add(error);
            }
        }


        FieldErrorResponse fieldErrorResponse = FieldErrorResponse.builder()
                .type(status.toString())
                .status(status.value())
                .message("Validation Failed")
                .errors(errors)
                .build();

        return new ResponseEntity<>(fieldErrorResponse, headers, status);
    }
}
