package com.thysmichels.service;

import com.thysmichels.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tmichels on 8/1/14.
 */

@Service
public class TodoServiceImpl implements TodoService {

    List<Todo> todos = new ArrayList<Todo>();

    @Override
    public List<Todo> allTodos() {
        return todos;
    }

    @Override
    public void addTodo(Todo todo) {
        todos.add(todo);
    }

    @Override
    public void deleteTodo(Todo todo) {
        if (todos.contains(todo)){
            todos.remove(todo);
        }
    }

    @Override
    public void deleteAll() {
        todos.clear();
    }

    @Override
    public void updateTodo(long position, Todo todo) {
        todos.set(new Long(position).intValue(), todo);
    }

    @Override
    public Todo getTodoById(long id) {
        return todos.get(new Long(id).intValue());
    }
}
