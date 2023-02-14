package com.congtan.todoapi.user.service;

import com.congtan.todoapi.user.domain.User;
import com.congtan.todoapi.user.model.CreateUserRequest;
import com.congtan.todoapi.user.model.UpdateUserRequest;
import com.congtan.todoapi.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    public User getUser(Integer id) {
        return repository.selectUser(id);
    }

    public List<User> getUsers() {
        return repository.selectUsers();
    }

    public void saveUser(CreateUserRequest request) {
        User user = User.toCreate(request.getFirstName(), request.getLastName(), request.getEmail(), request.getUsername(), request.getPassword());
        int rowEffected = repository.insertUser(user);
        if (rowEffected == 0) throw new RuntimeException();
    }

    public void deleteUser(Integer id) {
        int rowEffected = repository.deleteUser(id);
        if (rowEffected == 0) throw new RuntimeException();
    }

    public void updateUser(Integer id, UpdateUserRequest request) {
        User user = User.toUpdate(id, request.getFirstName(), request.getLastName(), request.getPassword());
        int rowEffected = repository.updateUser(user);
        if (rowEffected == 0) throw new RuntimeException();
    }
}
