package com.thysmichels.service;

import com.thysmichels.model.Todo;

import java.util.List;

/**
 * Created by tmichels on 8/1/14.
 */
public interface TodoService {
    public List<Todo> allTodos();
    public void addTodo(Todo todo);
    public void deleteTodo(Todo todo);
    public void deleteAll();
    public void updateTodo(long position, Todo todo);
    public Todo getTodoById(long id);
}
