package com.congtan.todoapi.todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class CreateTodoRequest {
//    @JsonProperty("title")
    private String title;

    private String content;

    @JsonProperty("completed")
    private Boolean status;

    @JsonProperty("due_date")
    private LocalDateTime dueDate;

    @JsonProperty("user_id")
    private Integer userId;
}
