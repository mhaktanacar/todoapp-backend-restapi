package com.example.todoapp.dao;

import com.example.todoapp.entity.TodoElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "todoElement", path= "todo-element" )
public interface TodoElementRepository extends JpaRepository<TodoElement, Long> {
}
