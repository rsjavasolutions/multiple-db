package com.rsjavasolutions.cache.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest implements Serializable {
    private String name;
    private String surname;
}
