package com.google.maps.task.management.system.entity;
import jakarta.persistence.*;
@Entity
@Table(name = "tasks") // Explicit table name
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String status;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity assignedUser; // Reference to the user assigned to this task
    // Default Constructor
    public TaskEntity() {}
    // Parameterized Constructor
    public TaskEntity(String title, String description, String status, UserEntity assignedUser) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignedUser = assignedUser;
    }
    // Getters and Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public UserEntity getAssignedUser() {
        return assignedUser;
    }
    public void setAssignedUser(UserEntity assignedUser) {
        this.assignedUser = assignedUser;
    }
}
