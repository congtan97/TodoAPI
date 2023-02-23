package com.congtan.todoapi.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UpdateTodoRequest {
    private String title;

    private String content;

    @JsonProperty("completed")
    private Boolean status;

    @JsonProperty("due_date")
    private LocalDateTime dueDate;
}
