package com.example.todo_API_REST.controller;

import com.example.todo_API_REST.entity.Todo;
import com.example.todo_API_REST.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    TodoService todoService;
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAll() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getById(@PathVariable int id) {
        return ResponseEntity.ok(todoService.getById(id));
    }
    @PostMapping
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoService.save(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Todo> update(@RequestBody Todo todo) {
        todoService.save(todo);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("/statute/valid")
    public ResponseEntity<List<Todo>> getValid() {
        return ResponseEntity.ok(todoService.searchByStatus(true));

    }
    @GetMapping("/statute/not_valid")
    public ResponseEntity<List<Todo>> getNotValid() {
        return ResponseEntity.ok(todoService.searchByStatus(false));

    }



}
