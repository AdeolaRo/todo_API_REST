package com.example.todo_API_REST.dao;

import com.example.todo_API_REST.entity.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
