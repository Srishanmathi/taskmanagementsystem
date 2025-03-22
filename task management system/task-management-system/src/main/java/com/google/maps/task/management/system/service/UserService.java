package com.google.maps.task.management.system.service;
import com.google.maps.task.management.system.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<Map<String, Object>> getAllUsersWithTaskCount() {
        List<Object[]> results = userRepository.getAllUsersWithTaskCount(); // 🔹 Fix: Corrected method call
        return results.stream().map(row -> Map.of(
                "User ID", row[0],
                "User Name", row[1],
                "Task Count", row[2]
        )).collect(Collectors.toList());
    }
}
