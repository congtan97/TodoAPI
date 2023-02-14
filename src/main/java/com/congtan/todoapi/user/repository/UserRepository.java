package com.congtan.todoapi.user.repository;

import com.congtan.todoapi.user.domain.User;

import java.util.List;

public interface UserRepository {
    User selectUser(Integer id);

    List<User> selectUsers();

    int insertUser(User user);

    int deleteUser(Integer id);

    int updateUser(User user);
}
