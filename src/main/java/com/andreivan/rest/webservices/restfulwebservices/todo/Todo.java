package com.andreivan.rest.webservices.restfulwebservices.todo;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;
import java.util.Random;

@Document(collection = "todo")
public class Todo {
    @Id
    private String id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

    protected Todo() {

    }

    public Todo(String username, String description, Date targetDate, boolean isDone) {
        //super();
//        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public String getId() {
        return id;
    }

    public void setId() {
        RandomString randomString = new RandomString();
        this.id = randomString.nextString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Todo)) return false;
        Todo todo = (Todo) o;
        return getId() == todo.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
