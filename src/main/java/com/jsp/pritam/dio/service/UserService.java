package com.jsp.pritam.dio.service;

import com.jsp.pritam.dio.dto.request.RegistrationRequest;
import com.jsp.pritam.dio.dto.request.UserRequest;
import com.jsp.pritam.dio.dto.response.UserResponse;
import com.jsp.pritam.dio.model.User;

public interface UserService {

    public UserResponse registration(RegistrationRequest userRequest);

    public UserResponse findUserById(long userId);

    public UserResponse updateUserById(long userId, UserRequest updateUser);


}
