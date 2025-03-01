package com.jsp.pritam.dio.dto.response;

import com.jsp.pritam.dio.enums.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponse {

    private long userid;

    private String username;

    private UserRole userrole;

    private LocalDateTime createdat;

    private LocalDateTime lastmodifiedat;
}
