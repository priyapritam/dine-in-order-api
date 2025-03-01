package com.jsp.pritam.dio.service.impl;

import com.jsp.pritam.dio.dto.request.RegistrationRequest;
import com.jsp.pritam.dio.dto.request.UserRequest;
import com.jsp.pritam.dio.dto.response.UserResponse;
import com.jsp.pritam.dio.enums.UserRole;
import com.jsp.pritam.dio.exception.UserNotFoundByIdException;
import com.jsp.pritam.dio.mapper.UserMapper;
import com.jsp.pritam.dio.model.Admin;
import com.jsp.pritam.dio.model.Staff;
import com.jsp.pritam.dio.model.User;
import com.jsp.pritam.dio.repository.UserRepository;
import com.jsp.pritam.dio.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse registration(RegistrationRequest userRequest) {
        User user = this.createUserByRole(userRequest.getUserrole());
        userMapper.mapToUserRequest(userRequest, user);

        return userMapper.mapToUserResponse(userRepository.save(user));
    }

    private User createUserByRole (UserRole role){
        User user2;
        switch (role){
            case ADMIN -> user2 = new Admin();
            case STAFF -> user2 = new Staff();
            default -> throw new RuntimeException("Failed to register user, Invalid user type");
        }
        return user2;
    }

    @Override
    public UserResponse findUserById(long userId) {
        User user= userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find user, user not found by id " + userId));
        return userMapper.mapToUserResponse(user);
    }

    @Override
    public UserResponse updateUserById(long userId, UserRequest updatedUser) {
        return userRepository.findById(userId)
                .map(exUser -> {
                    userMapper.mapToUserEntity(updatedUser, exUser);
                    userRepository.save(exUser);
                    return userMapper.mapToUserResponse(exUser);
                })
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find user, user not found by id " + userId));
    }
    }
