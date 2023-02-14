package com.congtan.todoapi.user.controller;

import com.congtan.todoapi.user.domain.User;
import com.congtan.todoapi.user.model.CreateUserRequest;
import com.congtan.todoapi.user.model.GetUserResponse;
import com.congtan.todoapi.user.model.GetUsersResponse;
import com.congtan.todoapi.user.model.UpdateUserRequest;
import com.congtan.todoapi.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

@RestController
@RequestMapping("/users")
public class UserController {
    @Value("${system.timezone}")
    private String systemTimeZone;
    @Autowired
    private UserService userService;

    @PostMapping()
    public void createUser(@RequestBody CreateUserRequest request) {
        userService.saveUser(request);
    }

    @GetMapping()
    public List<GetUsersResponse> getUsers(TimeZone timeZone) {
        return userService.getUsers().stream().map(user -> new GetUsersResponse(user.getId(), user.getUsername(), setToClientTime(timeZone, user.getCreatedAt()))).toList();
    }

    @GetMapping("/{id}")
    public GetUserResponse getUser(@PathVariable("id") Integer id, TimeZone timeZone) {
        User user = userService.getUser(id);
        return new GetUserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), setToClientTime(timeZone, user.getCreatedAt()), setToClientTime(timeZone, user.getUpdatedAt()));
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable("id") Integer id, @RequestBody UpdateUserRequest request) {
        userService.updateUser(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
    }

    private ZonedDateTime setToClientTime(TimeZone timeZone, LocalDateTime dbTime) {
        if (Objects.nonNull(dbTime)) {
            Instant instant = dbTime.atZone(ZoneId.of(systemTimeZone)).toInstant();
            return instant.atZone(timeZone.toZoneId());
        } else return null;
    }
}
