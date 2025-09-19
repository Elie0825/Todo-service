package com.example.todo.web;

import com.example.todo.domain.TodoStatus;
import com.example.todo.dto.TodoRequest;
import com.example.todo.dto.TodoResponse;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

  private final TodoService service;

  public TodoController(TodoService service) {
    this.service = service;
  }

  @GetMapping
  public ResponseEntity<List<TodoResponse>> list(
          @RequestParam Optional<TodoStatus> status,
          @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> dueBefore
  ) {
    return ResponseEntity.ok(service.list(status, dueBefore));
  }

  @GetMapping("/{id}")
  public ResponseEntity<TodoResponse> get(@PathVariable String id) {
    return ResponseEntity.ok(service.get(id));
  }

  @PostMapping
  public ResponseEntity<Void> create(@Valid @RequestBody TodoRequest request) {
    URI location = service.create(request);
    return ResponseEntity.created(location).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<TodoResponse> update(@PathVariable String id, @Valid @RequestBody TodoRequest request) {
    return ResponseEntity.ok(service.update(id, request));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable String id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
