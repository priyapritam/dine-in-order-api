package com.jsp.pritam.dio.mapper;

import com.jsp.pritam.dio.dto.request.RegistrationRequest;
import com.jsp.pritam.dio.dto.request.UserRequest;
import com.jsp.pritam.dio.dto.response.UserResponse;
import com.jsp.pritam.dio.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponse mapToUserResponse(User user);
    void mapToUserRequest(RegistrationRequest userRequest, @MappingTarget User user);
    void mapToUserEntity(UserRequest updatedUser, @MappingTarget User exuser);
}
