package com.example.todo.service;

import com.example.todo.domain.Todo;
import com.example.todo.domain.TodoStatus;
import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository repo;

    public TodoService(TodoRepository repo) {
        this.repo = repo;
    }

    public List<TodoResponse> list(Optional<TodoStatus> status, Optional<LocalDate> dueBefore) {
        List<Todo> todos;
        if (status.isPresent() && dueBefore.isPresent()) {
            todos = repo.findByStatusAndDueDateBefore(status.get(), dueBefore.get());
        } else if (status.isPresent()) {
            todos = repo.findByStatus(status.get());
        } else if (dueBefore.isPresent()) {
            todos = repo.findByDueDateBefore(dueBefore.get());
        } else {
            todos = repo.findAll();
        }
        return todos.stream().map(this::toResponse).toList();
    }

    public TodoResponse get(String id) {
        Todo t = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo " + id + " hittades inte"));
        return toResponse(t);
    }

    public URI create(TodoRequest req) {
        Todo t = new Todo();
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        if (req.getStatus() != null) t.setStatus(req.getStatus());
        t.setDueDate(req.getDueDate());
        Todo saved = repo.save(t);
        return URI.create("/api/todos/" + saved.getId());
    }

    public TodoResponse update(String id, TodoRequest req) {
        Todo t = repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Todo " + id + " hittades inte"));
        t.setTitle(req.getTitle());
        t.setDescription(req.getDescription());
        if (req.getStatus() != null) t.setStatus(req.getStatus());
        t.setDueDate(req.getDueDate());
        return toResponse(repo.save(t));
    }

    public void delete(String id) {
        if (!repo.existsById(id)) throw new ResourceNotFoundException("Todo " + id + " hittades inte");
        repo.deleteById(id);
    }

    private TodoResponse toResponse(Todo t) {
        return new TodoResponse(
                t.getId(), t.getTitle(), t.getDescription(), t.getStatus(),
                t.getDueDate(), t.getCreatedAt(), t.getUpdatedAt()
        );
    }
}
