package com.jsp.pritam.dio.service;

import com.jsp.pritam.dio.dto.request.RegistrationRequest;
import com.jsp.pritam.dio.dto.request.UserRequest;
import com.jsp.pritam.dio.dto.response.UserResponse;
import com.jsp.pritam.dio.model.User;

public interface UserService {

    /**
     * Registers a new user with the provided user registration details.
     *
     * @param userRequest the registration request that contains the new user's details such as username, email, phone number, password, and user role
     * @return the response containing user information such as ID, username, role, and timestamps for creation and last modification
     */
    public UserResponse registration(RegistrationRequest userRequest);

    /**
     * Retrieves a user's details by their unique identifier.
     *
     * @param userId the unique identifier of the user to be retrieved
     * @return a {@code UserResponse} object containing the user's details such as user ID, username, role, and timestamps
     */
    public UserResponse findUserById(long userId);

    /**
     * Updates an existing user's details based on their unique identifier.
     *
     * @param userId the unique identifier of the user to be updated
     * @param updateUser the request object containing the updated user details such as username, email, and phone number
     * @return a {@code UserResponse} object containing the updated user's details such as user ID, username, role,
     *         and timestamps for creation and last modification
     */
    public UserResponse updateUserById(long userId, UserRequest updateUser);


}
