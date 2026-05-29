package com.ratnesh.taskmanager.dto;

import com.ratnesh.taskmanager.entity.Priority;
import com.ratnesh.taskmanager.entity.Status;

import java.time.LocalDateTime;

public class TaskResponse {

    private Long id;

    private String title;

    private String description;

    private Status status;

    private Priority priority;

    private String assignedUserName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public TaskResponse() {
    }

    public TaskResponse(Long id,
                        String title,
                        String description,
                        Status status,
                        Priority priority,
                        String assignedUserName,
                        LocalDateTime createdAt,
                        LocalDateTime updatedAt) {

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignedUserName = assignedUserName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public String getAssignedUserName() {
        return assignedUserName;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}