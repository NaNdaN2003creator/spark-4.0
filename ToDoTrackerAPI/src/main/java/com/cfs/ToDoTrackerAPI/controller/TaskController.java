package com.cfs.ToDoTrackerAPI.controller;

import com.cfs.ToDoTrackerAPI.entity.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tasks")
public class TaskController
{
    // In-memory store for tasks (simple HashMap). Data lost on app restart.
    private Map<Long, Task> taskDB = new HashMap<>();

    // ----------------------------------------------------------------------
    // GET /tasks  (optional query param: dueBefore=yyyy-MM-dd)
    // ----------------------------------------------------------------------
    // Always wrap responses in ResponseEntity instead of returning plain Strings.
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(required = false) String dueBefore)
    {
        List<Task> tasks = new ArrayList<>(taskDB.values());

        // If dueBefore query param provided, filter tasks with dueDate <= cutoff
        if (dueBefore != null)
        {
            LocalDate cutoff = LocalDate.parse(dueBefore); // expects ISO format: yyyy-MM-dd
            List<Task> filtered = new ArrayList<>();
            for (Task task : tasks)
            {
                if (task.getDueDate() != null && !task.getDueDate().isAfter(cutoff))
                {
                    filtered.add(task);
                }
            }
            return ResponseEntity.ok(filtered);
        }

        // If no filter, return all tasks
        return ResponseEntity.ok(tasks);
    }

    // ----------------------------------------------------------------------
    // POST /tasks  – create a task
    // ----------------------------------------------------------------------
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task)
    {
        // Store the task in the in-memory map (client must provide id as per your controller)
        taskDB.put(task.getId(), task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

    // ----------------------------------------------------------------------
    // PATCH /tasks/{id}/status – partial update: update only status
    // ----------------------------------------------------------------------
    // Note: single method named updateStatus (no duplicates)
    @PatchMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(@PathVariable Long id, @RequestBody String newStatus)
    {
        Task existing = taskDB.get(id);
        if (existing == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        existing.setStatus(newStatus);
        taskDB.put(id, existing); // update stored object
        return ResponseEntity.ok(existing);
    }

    // ----------------------------------------------------------------------
    // DELETE /tasks/{id} – remove a task
    // ----------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id)
    {
        Task removed = taskDB.remove(id);
        if (removed == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
