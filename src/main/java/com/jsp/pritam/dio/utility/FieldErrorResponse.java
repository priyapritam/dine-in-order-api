package com.jsp.pritam.dio.utility;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@SuperBuilder
@Setter
public class FieldErrorResponse extends SimpleErrorResponse {

    private List<FieldError> errors;

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
