package com.congtan.todoapi.todo.service;

import com.congtan.todoapi.todo.domain.Todo;
import com.congtan.todoapi.todo.model.CreateTodoRequest;
import com.congtan.todoapi.todo.model.UpdateTodoRequest;

import java.util.List;

public interface TodoService {
    List<Todo> getTodos(Integer userId);

    int saveTodo(CreateTodoRequest request);

    void deleteTodo(Integer id);

    void updateTodo(Integer userId, Integer todoId, UpdateTodoRequest request);
}
