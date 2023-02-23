package com.congtan.todoapi.todo.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@Builder
public class Todo {
    private Integer id;
    private String title;
    private String content;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime dueDate;
    private Integer userId;

    public static Todo toCreate(String title, String content, Boolean status, LocalDateTime dueDate, Integer userId) {
        return Todo.builder()
                .title(title)
                .content(content)
                .status(status)
                .createdAt(LocalDateTime.now(ZoneId.of("UTC")))
                .dueDate(dueDate)
                .userId(userId)
                .build();
    }

    public static Todo toUpdate(String title, String content, Boolean status, LocalDateTime dueDate) {
        return Todo.builder()
                .title(title)
                .content(content)
                .status(status)
                .updatedAt(LocalDateTime.now(ZoneId.of("UTC")))
                .dueDate(dueDate)
                .build();
    }
}
