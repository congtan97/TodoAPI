package com.congtan.todoapi.todo.repository.impl;

import static com.congtan.todoapi.db.public_.tables.Todos.TODOS;
import com.congtan.todoapi.common.PersistenceAdapter;
import com.congtan.todoapi.todo.domain.Todo;
import com.congtan.todoapi.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@PersistenceAdapter
public class TodoRepositoryImpl implements TodoRepository {
    private final DSLContext context;

    @Override
    public List<Todo> selectTodos(Integer userId) {
        return context.selectFrom(TODOS)
                .where(TODOS.USER_ID.eq(userId))
                .fetchInto(Todo.class);
    }

    @Override
    public int insertTodo(Todo todo) {
        Record record = context.insertInto(TODOS)
                .set(TODOS.TITLE, todo.getTitle())
                .set(TODOS.CONTENT, todo.getContent())
                .set(TODOS.STATUS, todo.getStatus())
                .set(TODOS.CREATED_AT, todo.getCreatedAt())
                .set(TODOS.DUE_DATE, todo.getDueDate())
                .set(TODOS.USER_ID, todo.getUserId())
                .returning(TODOS.ID)
                .fetchOne();
        return record.get(TODOS.ID);
    }

    @Override
    public int deleteTodo(Integer todoId) {
        return context.deleteFrom(TODOS).where(TODOS.ID.eq(todoId)).execute();
    }

    @Transactional
    @Override
    public int updateTodo(Todo todo) {
        return context.update(TODOS)
                .set(TODOS.TITLE, todo.getTitle())
                .set(TODOS.CONTENT, todo.getContent())
                .set(TODOS.STATUS, todo.getStatus())
                .set(TODOS.UPDATED_AT, todo.getUpdatedAt())
                .set(TODOS.DUE_DATE, todo.getDueDate())
                .where(TODOS.ID.eq(todo.getId()))
                .execute();
    }
}
