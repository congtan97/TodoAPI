package com.congtan.todoapi.todo.controller;

import com.congtan.todoapi.todo.service.TodoService;
import com.congtan.todoapi.todo.service.impl.TodoServiceImpl;
import com.congtan.todoapi.todo.domain.Todo;
import com.congtan.todoapi.todo.model.CreateTodoRequest;
import com.congtan.todoapi.todo.model.GetTodosResponse;
import com.congtan.todoapi.todo.model.UpdateTodoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class TodoController {
    @Autowired
    private TodoService todoService;
    @GetMapping("/user/{id}/todos")
    public List<GetTodosResponse> getTodos(@PathVariable("id") Integer userId) {
        List<Todo> todos = todoService.getTodos(userId);
        return todos.stream().map(todo -> new GetTodosResponse(todo.getId(), todo.getTitle(), todo.getStatus())).toList();
    }

    @PostMapping("/user/{id}/todos")
    public GetTodosResponse createTodo(@RequestBody CreateTodoRequest request) {
        int id = todoService.saveTodo(request);
        return new GetTodosResponse(id, request.getTitle(), request.getStatus());
    }

    @DeleteMapping("/user/{user-id}/todo/{todo-id}")
    public void deleteTodo(@PathVariable("todo-id") Integer todoId) {
        todoService.deleteTodo(todoId);
    }

    @PutMapping("/user/{user-id}/todo/{todo-id}")
    public void updateTodo(@PathVariable("user-id") Integer userId, @PathVariable("todo-id") Integer todoId, @RequestBody UpdateTodoRequest request) {
        todoService.updateTodo(userId, todoId, request);
    }
}
