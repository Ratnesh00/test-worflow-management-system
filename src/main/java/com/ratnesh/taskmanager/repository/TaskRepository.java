package com.ratnesh.taskmanager.repository;

import com.ratnesh.taskmanager.entity.Task;
import com.ratnesh.taskmanager.entity.Status;
import com.ratnesh.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByAssignedUser(User user);

    List<Task> findByStatus(Status status);

    List<Task> findByAssignedUserAndStatus(User user, Status status);
}