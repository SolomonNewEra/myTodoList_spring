package com.sochez.myTodoList_spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Todo {
    //wrapper class for primitive datatype long
    @Id
    //Id is an interface
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String task;
    private Boolean completed;
}
