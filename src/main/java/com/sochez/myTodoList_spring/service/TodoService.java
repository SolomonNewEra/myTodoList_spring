package com.sochez.myTodoList_spring.service;

import com.sochez.myTodoList_spring.entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

    //Todo findById(final Long id); // A way to retrieve todo by id
    //Todo save(String task); // A way to save a new todo to the database
    //List<Todo> findAll(); // Returns all the todo items
    //Boolean completeTask(Long id); // Sets the status of the todo item associated with this id to true

    List<Todo> listOfMytodo();

    Todo saveMyTodo(String task);

    Optional<Todo> fetchTodoById(Long id);

    void deleteById(Long id);

    Todo updateToDo(Long id, Todo todo);
}
