package com.example.todo.dto;

import com.example.todo.domain.TodoStatus;
import java.time.Instant;
import java.time.LocalDate;

public record TodoResponse(
        String id,
        String title,
        String description,
        TodoStatus status,
        LocalDate dueDate,
        Instant createdAt,
        Instant updatedAt
) {}
