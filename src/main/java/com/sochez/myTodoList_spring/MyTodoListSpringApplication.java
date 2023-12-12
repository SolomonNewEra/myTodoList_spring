package com.sochez.myTodoList_spring;

import com.sochez.myTodoList_spring.entity.Todo;
import com.sochez.myTodoList_spring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyTodoListSpringApplication {

	@Autowired
	static
	TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyTodoListSpringApplication.class, args);


	}
}
