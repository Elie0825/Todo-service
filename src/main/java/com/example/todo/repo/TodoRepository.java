package com.example.todo.repo;

import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByStatus(TodoStatus status);
    List<Todo> findByDueDateBefore(LocalDate date);
    List<Todo> findByStatusAndDueDateBefore(TodoStatus status, LocalDate date);
}
