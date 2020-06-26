package com.example.todoapp.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "todo_list")
@Data
public class TodoList {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;
}
