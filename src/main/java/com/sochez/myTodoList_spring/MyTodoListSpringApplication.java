package com.sochez.myTodoList_spring;

import com.sochez.myTodoList_spring.entity.Todo;
import com.sochez.myTodoList_spring.repository.TodoRepository;
import com.sochez.myTodoList_spring.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTodoListSpringApplication implements CommandLineRunner {
	@Autowired
	private TodoRepository todoRepository;
	private TodoServiceImpl todoServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(MyTodoListSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Todo todo = new Todo();

		todo.setTask("Buy book");
		todo.setCompleted(false);
		todoRepository.save(todo);
		//todoServiceImpl.findById();



	}
}
