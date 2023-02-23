package com.congtan.todoapi.todo.service.impl;

import com.congtan.todoapi.todo.repository.TodoRepository;
import com.congtan.todoapi.todo.domain.Todo;
import com.congtan.todoapi.todo.model.CreateTodoRequest;
import com.congtan.todoapi.todo.model.UpdateTodoRequest;
import com.congtan.todoapi.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@Component
public class TodoServiceImpl implements TodoService {
    @Autowired
    private TodoRepository adapter;

    @Override
    public List<Todo> getTodos(Integer userId) {
        return adapter.selectTodos(userId);
    }

    @Override
    public int saveTodo(CreateTodoRequest request) {
        Todo todo = Todo.toCreate(request.getTitle(), request.getContent(), request.getStatus(),request.getDueDate(), request.getUserId());
        return adapter.insertTodo(todo);
    }

    @Override
    public void deleteTodo(Integer id) {
        if (adapter.deleteTodo(id) == 0) throw new RuntimeException();
    }

    @Override
    public void updateTodo(Integer userId, Integer todoId, UpdateTodoRequest request) {
        Todo todo = Todo.toUpdate(request.getTitle(), request.getContent(), request.getStatus(), request.getDueDate());
        if (adapter.updateTodo(todo) == 0) throw new RuntimeException();
    }
}
