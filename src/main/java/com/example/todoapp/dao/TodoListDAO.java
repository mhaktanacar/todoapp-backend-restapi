package com.example.todoapp.dao;

import com.example.todoapp.entity.TodoElement;
import com.example.todoapp.entity.TodoList;
import com.example.todoapp.entity.Users;

import java.util.List;

public interface TodoListDAO {

    public List<TodoList> findAll();

    public TodoList getList(int id);

    public Users getUser(String username);

    public TodoElement getElement(int id);

    public List<TodoElement> getByListId(int id);

    public List<TodoList> getListByUserName(String username);

    public void addList(TodoList list);

    public void addElement(TodoElement element);

    public void addUser(Users user);

    public void updateElement(TodoElement element, int id, String status);

    public void deleteList(int id);

    public void deleteElement(int id);

}
