package com.congtan.todoapi.user.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static User toCreate(String firstName, String lastName, String email, String username, String password) {
        return User.builder()
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .username(username)
                .password(password)
                .createdAt(LocalDateTime.now(ZoneId.of("UTC")))
                .build();
    }

    public static User toUpdate(Integer id, String firstName, String lastName, String password) {
        return User.builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .password(password)
                .updatedAt(LocalDateTime.now(ZoneId.of("UTC")))
                .build();
    }
}
