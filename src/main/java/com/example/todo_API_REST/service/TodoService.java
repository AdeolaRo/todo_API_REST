package com.example.todo_API_REST.service;

import com.example.todo_API_REST.dao.TodoRepository;
import com.example.todo_API_REST.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TodoService {

    TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    public Todo getById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public void delete(int id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> searchByStatus(boolean status) {
        List<Todo> todoList= (List<Todo>) todoRepository.findAll();

        if (!status)
            return todoList.stream().filter(todo -> !todo.isValidated()).toList();

        return todoList.stream().filter(Todo::isValidated).toList();
    }

}
