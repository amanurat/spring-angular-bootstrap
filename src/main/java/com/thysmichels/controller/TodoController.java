package com.thysmichels.controller;

import com.thysmichels.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.thysmichels.service.TodoService;

import java.util.List;

/**
 * Created by tmichels on 8/1/14.
 */

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/all.json")
    public @ResponseBody List<Todo> viewAllTodos(){
        return todoService.allTodos();
    }

    @RequestMapping(value = "/add/{todo}", method = RequestMethod.POST)
    public @ResponseBody void addTodo(@PathVariable("todo") String todo){
        Todo newTodo = new Todo();
        newTodo.setTodo(todo);
        todoService.addTodo(newTodo);
    }

    @RequestMapping(value = "/delete/{todo}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteTodo(@PathVariable("todo") String todoId){
        Todo deleteTodo = todoService.getTodoById(new Long(todoId));
        todoService.deleteTodo(deleteTodo);
    }

    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public @ResponseBody void deleteAllTodo(){
        todoService.deleteAll();
    }

    @RequestMapping(value="/update/{position}/{todo}", method = RequestMethod.PUT)
    public @ResponseBody void updateTodo(@PathVariable("position") String position, @PathVariable("todo") String todoId){
        Todo updateTodo = todoService.getTodoById(new Long(todoId));
        todoService.updateTodo(Long.valueOf(position), updateTodo);
    }

    @RequestMapping("/layout")
    public String getTodoPartialPage() {
        return "todo/layout";
    }
}
