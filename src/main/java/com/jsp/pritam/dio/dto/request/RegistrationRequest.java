package com.jsp.pritam.dio.dto.request;

import com.jsp.pritam.dio.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    @NotEmpty(message = "User name should not be empty")
    @NotBlank(message = "User name should not be Blank")
    private String username;

    @NotEmpty(message = "Email ID should not be empty")
    @NotBlank(message = "Email ID should not be blank")
    private String email;

    @NotEmpty(message = "Phone number should not be empty")
    @NotBlank(message = "Phone number should not be blank")
    private String phno;

    @NotEmpty(message = "Password should not be empty")
    @NotBlank(message = "Password should not be blank")
    private String password;

    private UserRole userrole;
}
