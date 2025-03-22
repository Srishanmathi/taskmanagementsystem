package com.google.maps.task.management.system.repository;
import com.google.maps.task.management.system.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    // ✅ Count tasks for a specific user
    long countByAssignedUserId(Long userId);
    // ✅ Find tasks by user ID
    List<TaskEntity> findByAssignedUserId(Long userId);
    // ✅ Find tasks by status (Pending, Completed, etc.)
    List<TaskEntity> findByStatus(String status);
    // ✅ Find tasks by user and status
    List<TaskEntity> findByAssignedUserIdAndStatus(Long userId, String status);
    // ✅ Sort tasks alphabetically
    @Query("SELECT t FROM TaskEntity t ORDER BY t.title ASC")
    List<TaskEntity> findAllSortedByTitle();
}
