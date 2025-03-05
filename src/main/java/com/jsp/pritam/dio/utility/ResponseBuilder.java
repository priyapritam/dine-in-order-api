package com.jsp.pritam.dio.utility;


import org.mapstruct.ap.internal.model.GeneratedType;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ResponseBuilder {

    /**
     * Constructs a {@link ResponseEntity} containing a {@link ResponseStructure} object.
     * This method wraps the provided status, message, and data into a standardized response structure.
     *
     * @param <T>   The type of the data to be included in the response.
     * @param status The HTTP status to be set in the response.
     * @param message A descriptive message providing additional context about the response.
     * @param data   The payload data of type T to be included in the response.
     * @return A {@link ResponseEntity} containing the constructed {@link ResponseStructure}.
     */

    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder().status(status.value()).message(message).data(data).build();

        return ResponseEntity.status(status).body(structure);
    }

    /**
     * Constructs a {@link ResponseEntity} containing a {@link ResponseStructure} object.
     * This method wraps the provided HTTP headers, status, message, and data into
     * a standardized response structure.
     *
     * @param <T>   The type of the data to be included in the response.
     * @param headers The HTTP headers to be included in the response.
     * @param status  The HTTP status to be set in the response.
     * @param message A descriptive message providing additional context about the response.
     * @param data    The payload data of type T to be included in the response.
     * @return A {@link ResponseEntity} containing the constructed {@link ResponseStructure}.
     */
    public static <T> ResponseEntity<ResponseStructure<T>> success(HttpHeaders headers, HttpStatus status, String message, T data) {
        ResponseStructure<T> structure = ResponseStructure.<T>builder()
                .status(status.value())
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.status(status).headers(headers).body(structure);
    }

    /**
     * Constructs a successful {@link ResponseEntity} containing a {@link ResponseStructure} object.
     * This method wraps the provided message and data into a standardized response structure
     * with an HTTP status of OK (200).
     *
     * @param <T>   The type of the data to be included in the response.
     * @param message A descriptive message providing additional context about the response.
     * @param data   The payload data of type T to be included in the response.
     * @return A {@link ResponseEntity} containing the constructed {@link ResponseStructure} with HTTP status OK (200).
     */
    public static<T> ResponseEntity<ResponseStructure<T>> ok(String message, T data) {
        return success(HttpStatus.OK, message, data);
    }

    /**
     * Constructs a {@link ResponseEntity} containing a {@link SimpleErrorResponse} object.
     * This method generates a standardized error response with the provided HTTP status and message.
     *
     * @param status  The HTTP status to be set in the error response.
     * @param message A descriptive message providing additional context about the error.
     * @return A {@link ResponseEntity} containing the constructed {@link SimpleErrorResponse}.
     */
    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message) {
        SimpleErrorResponse error = SimpleErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .build();

        return ResponseEntity.status(status).body(error);
    }

    /**
     * Constructs a {@link ResponseEntity} containing a {@link FieldErrorResponse} object.
     * This method generates a standardized error response with the provided HTTP status,
     * message, and a list of field-specific errors.
     *
     * @param status      The HTTP status to be set in the error response.
     * @param message     A descriptive message providing additional context about the error.
     * @param fieldErrors A list of field-specific errors to include in the response.
     * @return A {@link ResponseEntity} containing the constructed {@link SimpleErrorResponse}.
     */
    public static ResponseEntity<SimpleErrorResponse> error(HttpStatus status, String message, List<FieldErrorResponse.FieldError> fieldErrors) {
        FieldErrorResponse error = FieldErrorResponse.builder()
                .type(status.name())
                .message(message)
                .status(status.value())
                .errors(fieldErrors)
                .build();

        return ResponseEntity.status(status).body(error);
    }

    /**
     * Constructs a {@link ResponseEntity} containing a {@link SimpleErrorResponse} object
     * with a "Not Found" (404) HTTP status and the provided error message.
     *
     * @param message A descriptive message providing additional context about the "Not Found" error.
     * @return A {@link ResponseEntity} containing the constructed {@link SimpleErrorResponse}.
     */
    public static ResponseEntity<SimpleErrorResponse> notFound(String message) {
        return error(HttpStatus.NOT_FOUND, message);
    }
}
