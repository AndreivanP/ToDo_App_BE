package com.andreivan.rest.webservices.restfulwebservices.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoMongoResource {

    @Autowired
    private TodoMongoRepository todoMongoRepository;

    @GetMapping("users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoMongoRepository.findByUsername(username);
    }

    @GetMapping("users/{username}/todos/{id}")
    public List<Todo> getTodo(@PathVariable String username, @PathVariable String id) {
        return todoMongoRepository.findStringById(id);
    }

    @DeleteMapping("users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable String id) {
        todoMongoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable(value="id") String id, @RequestBody Todo todo) {
        todo.setUsername(username);
        todoMongoRepository.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        todo.setId();
        Todo createdTodo = todoMongoRepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
