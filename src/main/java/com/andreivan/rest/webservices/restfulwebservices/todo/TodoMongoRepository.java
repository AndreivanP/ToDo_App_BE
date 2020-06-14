package com.andreivan.rest.webservices.restfulwebservices.todo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TodoMongoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByUsername(String username);

    void deleteById(String id);

    List<Todo> findStringById(String id);
}
