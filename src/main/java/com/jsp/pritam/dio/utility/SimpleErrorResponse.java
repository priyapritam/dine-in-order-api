package com.jsp.pritam.dio.utility;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class SimpleErrorResponse {

    private String type;

    private int status; // 404

    private String message;
}
