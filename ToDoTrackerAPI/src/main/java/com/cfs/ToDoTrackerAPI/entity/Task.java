package com.cfs.ToDoTrackerAPI.entity;

import java.time.LocalDate;

// Simple POJO model for Task (fields: id, title, description, status, dueDate)
public class Task {
    private Long id;             // unique id for each task
    private String title;        // short title or name of the task
    private String description;  // details about the task
    private String status;       // "PENDING" or "DONE"
    private LocalDate dueDate;   // due date in yyyy-MM-dd

    public Task() {}

    public Task(Long id, String title, String description, String status, LocalDate dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.dueDate = dueDate;
    }

    // getters and setters — NOTE: getDueDate() is present (fixes the missing-symbol error)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
