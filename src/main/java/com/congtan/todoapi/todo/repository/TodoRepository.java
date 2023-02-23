package com.congtan.todoapi.todo.repository;

import com.congtan.todoapi.todo.domain.Todo;

import java.util.List;

public interface TodoRepository {
    List<Todo> selectTodos(Integer userId);

    int insertTodo(Todo todo);

    int deleteTodo(Integer todoId);

    public int updateTodo(Todo todo);
}
