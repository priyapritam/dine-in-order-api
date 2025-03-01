package com.jsp.pritam.dio.utility;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.FieldError;

@Getter
@SuperBuilder
public class FieldErrorResponse extends SimpleErrorResponse {

    private FieldError fieldError;

    public static FieldError fieldError(String message, Object rejectvalue, String field){
        FieldError error = new FieldError();

        error.message = message;
        error.rejectedvalue = rejectvalue;
        error.field = field;

        return error;
    }

    @Getter
    public static class FieldError{
        private String message;

        private Object rejectedvalue;

        private String field;
    }
}
