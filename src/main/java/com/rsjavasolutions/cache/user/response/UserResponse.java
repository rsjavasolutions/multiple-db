package com.rsjavasolutions.cache.user.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponse {
    private final String uuid;
    private final long id;
    private final String name;
    private final String surname;
    private final LocalDateTime creationDateTime;
}
