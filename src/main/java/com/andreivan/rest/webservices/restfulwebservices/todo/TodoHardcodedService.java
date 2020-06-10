package com.andreivan.rest.webservices.restfulwebservices.todo;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Andreivan", "Learn to play guitar", new Date(), false));
        todos.add(new Todo(++idCounter, "Andreivan", "Learn how to use mocks", new Date(), false));
        todos.add(new Todo(++idCounter, "Andreivan", "Learn about microservices", new Date(), false));
        todos.add(new Todo(++idCounter, "Andreivan", "Learn about docker", new Date(), false));
    }

    public Todo save(Todo todo) {
        if(todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
        } else {
            deleteById(todo.getId());
        }
        todos.add(todo);
        return todo;
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        if(todo==null) {
            return null;
        }
        if(todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public Todo findById(long id) {
        for(Todo todo:todos) {
            if(todo.getId() == id) {
                return todo;
            }
        }
        return null;
    }
}
