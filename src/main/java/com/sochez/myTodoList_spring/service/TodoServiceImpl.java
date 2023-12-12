package com.sochez.myTodoList_spring.service;

import com.sochez.myTodoList_spring.entity.Todo;
import com.sochez.myTodoList_spring.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    // This is using constructor injection, which is recommended way of injection dependencies in spring.
    // With the help of @RequiredArgsConstructor on top of the class, a constructor is created with this field
    private final TodoRepository todoRepository;

    @Override
    public List<Todo> listOfMytodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo saveMyTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Optional<Todo> fetchTodoById(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public Todo updateToDo(Long id, Todo todo) {
        Todo TempTodo=todoRepository.findById(id).get();

        if(Objects.nonNull(todo.getTask()) && !"".equalsIgnoreCase(todo.getTask())){
            TempTodo.setTask(todo.getTask());
        }
        if(Objects.nonNull(todo.getCompleted()) && !"".equalsIgnoreCase(todo.getCompleted().toString())){
            TempTodo.setCompleted(todo.getCompleted());
        }
        return todoRepository.save(TempTodo);
    }

}
