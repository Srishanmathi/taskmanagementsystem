package com.google.maps.task.management.system.controller;
import com.google.maps.task.management.system.entity.TaskEntity;
import com.google.maps.task.management.system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;
    // ✅ Get all tasks
    @GetMapping
    public List<TaskEntity> getAllTasks() {
        return taskService.getAllTasks();
    }
    // ✅ Get task by ID
    @GetMapping("/{id}")
    public Optional<TaskEntity> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
    // ✅ Count tasks for a specific user
    @GetMapping("/{userId}/count")
    public long countTasksPerUser(@PathVariable Long userId) {
        return taskService.countTasksPerUser(userId);
    }
    // ✅ Get tasks sorted by title
    @GetMapping("/sorted")
    public List<TaskEntity> getTasksSortedByTitle() {
        return taskService.getTasksSortedByTitle();
    }
}
