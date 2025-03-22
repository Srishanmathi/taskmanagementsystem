package com.google.maps.task.management.system.service;
import com.google.maps.task.management.system.entity.TaskEntity;
import com.google.maps.task.management.system.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    // ✅ Get all tasks
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }
    // ✅ Get a task by ID
    public Optional<TaskEntity> getTaskById(Long id) {
        return taskRepository.findById(id);
    }
    // ✅ Count tasks assigned to a user
    public long countTasksPerUser(Long userId) {
        return taskRepository.countByAssignedUserId(userId);
    }
    // ✅ Get all tasks assigned to a specific user
    public List<TaskEntity> getTasksByUser(Long userId) {
        return taskRepository.findByAssignedUserId(userId);
    }
    // ✅ Get tasks by status (Pending, Completed, etc.)
    public List<TaskEntity> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }
    // ✅ Get tasks by user and status
    public List<TaskEntity> getTasksByUserAndStatus(Long userId, String status) {
        return taskRepository.findByAssignedUserIdAndStatus(userId, status);
    }
    // ✅ Get tasks sorted alphabetically
    public List<TaskEntity> getTasksSortedByTitle() {
        return taskRepository.findAllSortedByTitle();
    }
}
