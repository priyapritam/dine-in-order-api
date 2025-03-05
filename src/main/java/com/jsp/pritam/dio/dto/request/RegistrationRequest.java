package com.jsp.pritam.dio.dto.request;

import com.jsp.pritam.dio.enums.UserRole;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequest {

    @NotEmpty(message = "User name should not be empty")
    @NotBlank(message = "User name should not be Blank")
    @Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "User name can conntain only Alphabets, Numbers and Underscore")
    private String username;

    @NotEmpty(message = "Email ID should not be empty")
    @NotBlank(message = "Email ID should not be blank")
    @Email(message = "Invalid email format. Example: user@example.com")
    @Size(max =  50, message = "Email ID should not exceed 50 characters")
    private String email;

    @NotEmpty(message = "Phone number should not be empty")
    @NotBlank(message = "Phone number should not be blank")
    @Size(min = 10, max = 10, message = "Phone number should be of 10 digits")
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must contain exactly 10 digits")
    private String phno;

    @NotEmpty(message = "Password should not be empty")
    @NotBlank(message = "Password should not be blank")
    @Size(min = 8, max = 16, message = "Password must be between 8 to 16 characters")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])[A-Za-z\\d@#$%^&+=!]{8,16}$",
            message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character")
    private String password;

    private UserRole userrole;
}
