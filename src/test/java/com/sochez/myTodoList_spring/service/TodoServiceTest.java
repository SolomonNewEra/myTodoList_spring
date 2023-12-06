package com.sochez.myTodoList_spring.service;

import com.sochez.myTodoList_spring.entity.Todo;
import com.sochez.myTodoList_spring.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoServiceTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @Test
    void shouldReturnNullForNonExistingTodo() {
        assertNull(todoService.findById(new Random().nextLong()), "Should return null! Todo doesn't exist");
    }

    @Test
    void saveTodoThenFindByIdSuccessfully(TestInfo testInfo) {
        // Given

        // Save a new Todo instance to the database
        Todo newTodo = todoService.save(testInfo.getDisplayName());

        assertNotNull(newTodo, "save method should never return null");
        assertNotNull(newTodo.getId(), "Saved Todo should now have an Id associated");

        // When

        // Test that the todo can be fetched from the database by id.
        Todo storedTodo = todoService.findById(newTodo.getId());

        // Then
        assertNotNull(storedTodo, "Todo should be retrieved successfully");
        assertEquals(newTodo, storedTodo);
    }

    @Test
    void shouldReturnFalseForCompletingNonExistingTodo() {
        assertFalse(todoService.completeTask(new Random().nextLong()), "Todo does not exist");
    }

    @Test
    void shouldCompleteNewTaskSuccessfully(TestInfo testInfo) {
        // Given
        Todo newTodo = todoService.save(testInfo.getDisplayName());
        assertFalse(newTodo.getCompleted(), "A new todo should not be completed");

        // When
        Boolean status = todoService.completeTask(newTodo.getId());
        assertTrue(status);

        //Then
        Todo storedTodo = todoService.findById(newTodo.getId());
        assertTrue(storedTodo.getCompleted(), "Todo should now be marked completed");
    }

    @Test
    void stressTest(TestInfo testInfo) {
        // First clear all the items in the database
        todoRepository.deleteAll();

        // Add 10 todo items to the database
        IntStream.range(0, 10).forEach(index -> todoService.save(testInfo.getDisplayName() + index));

        // make sure we get 10 items back successfully
        List<Todo> todos = todoService.findAll();
        assertEquals(10, todos.size(), "Should be 10 todos in the database");

        // Make sure the tasks we added are what we got back
        for (int index = 0; index < 10; index++) {
            assertEquals(testInfo.getDisplayName() + index, todos.get(index).getTask());
        }
    }

}