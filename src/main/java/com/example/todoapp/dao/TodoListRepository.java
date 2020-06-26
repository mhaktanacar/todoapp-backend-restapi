package com.example.todoapp.dao;

import com.example.todoapp.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListRepository extends JpaRepository<TodoList, Long> {


}
