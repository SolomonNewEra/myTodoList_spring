package com.sochez.myTodoList_spring.service;

import com.sochez.myTodoList_spring.entity.Todo;
import com.sochez.myTodoList_spring.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private Todo todo;

    private final TodoRepository todoRepository;

    @Override
    public Todo findById(Long id) {
        return findById(id);
    }

    @Override
    public Todo save(String task) {
        return todoRepository.save(todo);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Boolean completeTask(Long id) {
        return todo.getCompleted();
    }

}
