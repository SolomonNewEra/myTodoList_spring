package com.sochez.myTodoList_spring.service;

import com.sochez.myTodoList_spring.entity.Todo;
import com.sochez.myTodoList_spring.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    // This is using constructor injection, which is recommended way of injection dependencies in spring.
    // With the help of @RequiredArgsConstructor on top of the class, a constructor is created with this field
    private final TodoRepository todoRepository;

    @Override
    public Todo findById(Long id) {
        // Retrieves the todo by id from the database and if no dodo is available, it will return null
        return todoRepository.findById(id).orElse(null);
    }

    @Override
    public Todo save(String task) {
        Todo todo = new Todo();
        todo.setTask(task);
        todo.setCompleted(Boolean.FALSE); // All todos will have completed set to false unless they are completed.

        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Boolean completeTask(Long id) {
        // Retrieve the todo that we want to change the completed field from the database by id.
        Optional<Todo> optionalTodo = todoRepository.findById(id);

        // if that todo is present, we want to retrieve it and change the completed field to true.
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setCompleted(Boolean.TRUE);

            // Once this change is done, we need to save it back to the database with the new changes.
            todoRepository.save(todo);
            // return true that the change was successful.
            return true;
        }
        // if not present, then return that the change was not successful
        return false;
    }

}
