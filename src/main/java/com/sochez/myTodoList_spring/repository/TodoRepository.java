package com.sochez.myTodoList_spring.repository;

import com.sochez.myTodoList_spring.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
