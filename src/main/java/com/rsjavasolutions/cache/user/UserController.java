package com.rsjavasolutions.cache.user;

import com.rsjavasolutions.cache.car.service.UserService;
import com.rsjavasolutions.cache.user.request.UserRequest;
import com.rsjavasolutions.cache.user.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse getUser(@PathVariable String uuid) {
        return userService.getUser(uuid);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Set<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String saveUser(@RequestBody UserRequest request) {
        return userService.saveUser(request);
    }

    @DeleteMapping("{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String uuid) {
        userService.deleteUser(uuid);
    }

    @PutMapping("{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public UserResponse updateUser(@PathVariable String uuid, @RequestBody UserRequest request) {
        return userService.updateUser(uuid, request);
    }
}
