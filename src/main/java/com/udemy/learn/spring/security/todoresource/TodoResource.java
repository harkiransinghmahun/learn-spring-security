package com.udemy.learn.spring.security.todoresource;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class TodoResource {

    private List<Todo> TODOS = new ArrayList<>(List.of(new Todo("harkiran", "Des 1"),
                                       new Todo("harkiran", "Des 2")));


//    @GetMapping("/todos")
//    public List<Todo> getAllTodos(){
//        return TODOS;
//    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> getSpecificTodoForUser(@PathVariable String username){
        return TODOS.stream().filter(todo -> todo.username().equals(username)).toList();
    }
    
    @PostMapping("/users/{username}/todos")
    public void addNewTodo(@RequestBody Todo todo){
        TODOS.add(todo);
    }

}

record Todo(String username, String description){}
