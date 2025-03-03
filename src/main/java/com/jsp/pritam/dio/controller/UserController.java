package com.jsp.pritam.dio.controller;

import com.jsp.pritam.dio.dto.request.RegistrationRequest;
import com.jsp.pritam.dio.dto.request.UserRequest;
import com.jsp.pritam.dio.dto.response.UserResponse;
import com.jsp.pritam.dio.model.User;
import com.jsp.pritam.dio.service.UserService;
import com.jsp.pritam.dio.utility.FieldErrorResponse;
import com.jsp.pritam.dio.utility.ResponseBuilder;
import com.jsp.pritam.dio.utility.ResponseStructure;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@Tag(name = "User Controller", description = "Collection API Endpoints dealing user data.")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(description = """
            The API Endpoint to register a new user.
            The endpoint requires the user to select one of the specified roles Among with the registration details.
            """, responses = {@ApiResponse(responseCode = "201", description = "User Created"),
                                @ApiResponse(responseCode = "400", description = "Invalid Input", content = {
                                        @Content(schema = @Schema(implementation = FieldErrorResponse.class))
                                })})
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid RegistrationRequest userRequest){
        UserResponse userResponse = userService.registration(userRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User Created", userResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findUserById(@PathVariable long userId){
        UserResponse user = userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Found", user);
    }

    @PostMapping("update/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateUserById(@PathVariable long userId, @RequestBody @Valid UserRequest updatedUser){
        UserResponse user = userService.updateUserById(userId, updatedUser);
        return ResponseBuilder.success(HttpStatus.OK, "User UPdated", user);
    }
}
