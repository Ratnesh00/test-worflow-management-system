package com.ratnesh.taskmanager.repository;

import com.ratnesh.taskmanager.entity.Status;
import com.ratnesh.taskmanager.entity.Task;
import com.ratnesh.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Custom query method: Find tasks assigned to a specific user
    List<Task> findByAssignedUser(User user);

    // Custom query method: Find tasks by status (e.g., all "OPEN" tasks)
    List<Task> findByStatus(Status status);
}