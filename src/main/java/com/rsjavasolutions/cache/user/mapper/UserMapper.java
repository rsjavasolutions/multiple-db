package com.rsjavasolutions.cache.user.mapper;

import com.rsjavasolutions.cache.user.UserEntity;
import com.rsjavasolutions.cache.user.request.UserRequest;
import com.rsjavasolutions.cache.user.response.UserResponse;

public class UserMapper {

    public static UserEntity mapToEntity(UserRequest request) {
        return new UserEntity(
                request.getName(),
                request.getSurname());
    }

    public static UserResponse mapToResponse(UserEntity entity) {
        return new UserResponse(
                entity.getUuid(),
                entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getCreationDateTime()
        );
    }
}
