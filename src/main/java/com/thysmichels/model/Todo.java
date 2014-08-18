package com.thysmichels.model;

/**
 * Created by tmichels on 8/17/14.
 */

public class Todo {

    private long id;
    private String todo;

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
