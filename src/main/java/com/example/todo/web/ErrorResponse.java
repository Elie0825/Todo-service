package com.example.todo.web;

import java.time.OffsetDateTime;

public class ErrorResponse {
    private final int status;
    private final String error;
    private final String message;
    private final String path;
    private final OffsetDateTime timestamp = OffsetDateTime.now();

    public ErrorResponse(int status, String error, String message, String path) {
        this.status = status; this.error = error; this.message = message; this.path = path;
    }

    public int getStatus() { return status; }
    public String getError() { return error; }
    public String getMessage() { return message; }
    public String getPath() { return path; }
    public OffsetDateTime getTimestamp() { return timestamp; }
}
