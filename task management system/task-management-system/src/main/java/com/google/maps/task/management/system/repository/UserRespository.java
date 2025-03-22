package com.google.maps.task.management.system.repository;
import com.google.maps.task.management.system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // ✅ Query to get a single user's task count
    @Query("SELECT u.id, u.name, COUNT(t.id) FROM UserEntity u LEFT JOIN TaskEntity t ON u.id = t.assignedUser.id WHERE u.id = :userId GROUP BY u.id, u.name")
    Object getUserWithTaskCount(Long userId);
    // ✅ Query to get task count for all users
    @Query("SELECT u.id, u.name, COUNT(t.id) FROM UserEntity u LEFT JOIN TaskEntity t ON u.id = t.assignedUser.id GROUP BY u.id, u.name")
    List<Object[]> getAllUsersWithTaskCount(); // 🔹 Fix: Corrected method name
}
