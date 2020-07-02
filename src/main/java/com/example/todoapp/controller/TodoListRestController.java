package com.example.todoapp.controller;

import com.example.todoapp.dao.TodoListDAO;
import com.example.todoapp.entity.TodoElement;
import com.example.todoapp.entity.TodoList;
import com.example.todoapp.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoListRestController {

    private TodoListDAO todoListDAO;

    @Autowired
    public TodoListRestController(TodoListDAO rep) {
        todoListDAO = rep;
    }

    //Get

    @GetMapping("/todolists")
    public List<TodoList> findAll() {

        return todoListDAO.findAll();
    }

    @GetMapping("/todolists/{id}")
    public TodoList getList(@PathVariable int id) {

        return todoListDAO.getList(id);
    }

    @GetMapping("/users/{username}")
    public Users getUser(@PathVariable String username) {

        return todoListDAO.getUser(username);
    }

    @GetMapping("/todoelement/{id}")
    public TodoElement getElement(@PathVariable int id) {
        return todoListDAO.getElement(id);
    }

    @GetMapping("/todoelements/{id}")
    public List<TodoElement> getByListId(@PathVariable int id) {

        return todoListDAO.getByListId(id);
    }

    @GetMapping("/{username}/todolists/")
    public List<TodoList> getByListId(@PathVariable String username) {

        return todoListDAO.getListByUserName(username);
    }

    //add

    @PostMapping("/todolists")
    public TodoList addList(@RequestBody TodoList list) {

        list.setId(0);
        todoListDAO.addList(list);

        return list;
    }

    @PostMapping("/todoelement/{id}")
    public TodoElement addElement(@RequestBody TodoElement element, @PathVariable int id) {


        element.setId(0);
        element.setTodoList(getList(id));
        todoListDAO.addElement(element);

        return element;
    }

    @PostMapping("/users")
    public Users addUser(@RequestBody Users user) {
        user.setId(0);
        todoListDAO.addUser(user);

        return user;
    }

    //update

    @PutMapping("/todoelement/{id}")
    public TodoElement updateElement(@RequestBody TodoElement element, @PathVariable int id){

        String status = element.getStatus();



        todoListDAO.updateElement(element, id, status);

        return element;
    }

    //delete

    @DeleteMapping("/todolists/{id}")
    public String deleteList(@PathVariable int id) {

        todoListDAO.deleteList(id);

        return "Deleted list with id: " + id;
    }

    @DeleteMapping("/todoelement/{id}")
    public String deleteElement(@PathVariable int id) {

        todoListDAO.deleteElement(id);

        return "Deleted element with id: " + id;
    }


}
