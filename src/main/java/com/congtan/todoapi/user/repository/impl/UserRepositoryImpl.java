package com.congtan.todoapi.user.repository.impl;

import static com.congtan.todoapi.db.public_.tables.Users.USERS;
import static com.congtan.todoapi.db.public_.tables.Todos.TODOS;

import com.congtan.todoapi.user.domain.User;
import com.congtan.todoapi.user.repository.UserRepository;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private DSLContext context;

    @Override
    public User selectUser(Integer id) {
        return context.selectFrom(USERS)
                .where(USERS.ID.eq(id))
                .fetchOneInto(User.class);
    }

    @Override
    public List<User> selectUsers() {
        return context.selectFrom(USERS)
                .fetchInto(User.class);
    }

    @Override
    public int insertUser(User user) {
        return context.insertInto(USERS)
                .set(USERS.FIRST_NAME, user.getFirstName())
                .set(USERS.LAST_NAME, user.getLastName())
                .set(USERS.EMAIL, user.getEmail())
                .set(USERS.USERNAME, user.getUsername())
                .set(USERS.PASSWORD, user.getPassword())
                .set(USERS.CREATED_AT, user.getCreatedAt())
                .execute();
    }

    @Transactional
    @Override
    public int deleteUser(Integer id) {
        context.deleteFrom(TODOS).where(TODOS.USER_ID.eq(id)).execute();
        return context.delete(USERS)
                .where(USERS.ID.eq(id))
                .execute();
    }

    @Override
    public int updateUser(User user) {
        return context.update(USERS)
                .set(USERS.FIRST_NAME, user.getFirstName())
                .set(USERS.LAST_NAME, user.getLastName())
                .set(USERS.UPDATED_AT, user.getUpdatedAt())
                .set(USERS.PASSWORD, user.getPassword())
                .where(USERS.ID.eq(user.getId()))
                .execute();
    }
}
