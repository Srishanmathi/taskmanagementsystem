package com.google.maps.task.management.system.controller;
import com.google.maps.task.management.system.entity.UserEntity;
import com.google.maps.task.management.system.repository.UserRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    // ✅ Get task count for each user
    @GetMapping("/count")
    public List<Map<String, Object>> getAllUsersWithTaskCount() {
        List<Object[]> results = userRepository.getAllUsersWithTaskCount();
        return results.stream().map(row -> Map.of(
                "User ID", row[0],
                "User Name", row[1],
                "Task Count", row[2]
        )).collect(Collectors.toList());
    }
    @GetMapping("/{id}/task-count")
    public Map<String, Object> getUserTaskCount(@PathVariable Long id) {
        Object result = userRepository.getUserWithTaskCount(id);
        if (result != null) {
            Object[] row = (Object[]) result;
            return Map.of(
                    "User ID", row[0],
                    "User Name", row[1],
                    "Task Count", row[2]
            );
        } else {
            return Map.of("message", "User not found or has no tasks");
        }
    }
    @GetMapping("/{id}") // Example: GET /users/1
    public String getUserById(@PathVariable Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            return "User Found: ID: " + user.getId() + " | Name: " + user.getName() + " | Email: " + user.getEmail();
        } else {
            return "User not found with ID: " + id;
        }
    }
}
