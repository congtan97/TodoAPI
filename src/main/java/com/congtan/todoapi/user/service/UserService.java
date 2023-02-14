package com.congtan.todoapi.user.service;

import com.congtan.todoapi.user.domain.User;
import com.congtan.todoapi.user.model.CreateUserRequest;
import com.congtan.todoapi.user.model.UpdateUserRequest;

import java.util.List;

public interface UserService {
    User getUser(Integer id);

    List<User> getUsers();

    void saveUser(CreateUserRequest request);

    void deleteUser(Integer id);

    void updateUser(Integer id, UpdateUserRequest request);
}
