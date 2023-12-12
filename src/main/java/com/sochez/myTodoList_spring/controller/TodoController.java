package com.sochez.myTodoList_spring.controller;

import com.sochez.myTodoList_spring.entity.Todo;
import com.sochez.myTodoList_spring.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TodoController {
    Todo todo;
    @Autowired
    TodoService todoService;

    @GetMapping("/")
   public List<Todo> listOfMytodo(){
       return todoService.listOfMytodo();

    }

    @PostMapping("/save")
    public Todo saveMyTodo(@RequestBody Todo todo){
        return todoService.saveMyTodo(todo);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        todoService.deleteById(id);
        return "Task deleted successfully";
    }

    @GetMapping("/task/{id}")
    public Optional<Todo> fetchTodoById(@PathVariable("id") Long id){
        return todoService.fetchTodoById(id);
    }

    @PutMapping("/update/{id}")
    public Todo updateToDo(@PathVariable("id") Long id, Todo todo){
        return todoService.updateToDo(id, todo);
    }
}
