package com.example.todoapp.dao;

import com.example.todoapp.entity.TodoElement;
import com.example.todoapp.entity.TodoList;
import com.example.todoapp.entity.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TodoListDAOImpl implements TodoListDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public TodoListDAOImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    //get

    @Override
    @Transactional
    public List<TodoList> findAll() {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<TodoList> theQuery =
                currentSession.createQuery("from TodoList", TodoList.class);

        List<TodoList> todos =  theQuery.getResultList();

        return todos;
    }

    @Override
    @Transactional
    public TodoList getList(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        TodoList list = currentSession.get(TodoList.class, id);


        return list;
    }

    @Override
    public Users getUser(String username) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Users> theQuery =
                currentSession.createQuery("from Users where username=:userName", Users.class);

        theQuery.setParameter("userName", username);

        List<Users> users =  theQuery.getResultList();

        return users.get(0);
    }

    @Override
    public TodoElement getElement(int id) {

        Session currentSession = entityManager.unwrap(Session.class);

        TodoElement element = currentSession.get(TodoElement.class, id);

        return element;
    }

    @Override
    public List<TodoElement> getByListId(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        TodoList tempTodoList = currentSession.get(TodoList.class, id);

        List<TodoElement> todoElements =  tempTodoList.getTodoElements();

        return todoElements;
    }

    @Override
    public List<TodoList> getListByUserName(String userName) {

        Session currentSession = entityManager.unwrap(Session.class);

        Query<Users> theQuery =
                currentSession.createQuery("from Users where username=:userName", Users.class);

        theQuery.setParameter("userName", userName);


        List<Users> users =  theQuery.getResultList();

        Users tempUser = users.get(0);

        List<TodoList> todoLists =  tempUser.getTodoLists();

        return todoLists;
    }

    //add

    @Override
    public void addList(TodoList list) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(list);

    }

    @Override
    public void addElement(TodoElement element) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(element);
    }

    @Override
    public void addUser(Users user) {

        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(user);

    }

    @Override
    public void updateElement(TodoElement element, int id, String status) {
        Session currentSession = entityManager.unwrap(Session.class);

        element = getElement(id);
        element.setStatus(status);

        currentSession.saveOrUpdate(element);

    }

    //delete

    @Override
    @Transactional
    public void deleteList(int theId) {

        List<TodoElement> tempList = getByListId(theId);

        for(int i=0; i<tempList.size(); i++){
            deleteElement(tempList.get(i).getId());
        }

        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from TodoList where id=:listId");

        theQuery.setParameter("listId", theId);

        theQuery.executeUpdate();

    }

    @Override
    @Transactional
    public void deleteElement(int theId) {

        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery =
                currentSession.createQuery("delete from TodoElement where id=:elementId");

        theQuery.setParameter("elementId", theId);

        theQuery.executeUpdate();

    }


}
