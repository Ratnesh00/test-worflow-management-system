package com.ratnesh.taskmanager.service;

import com.ratnesh.taskmanager.entity.Status;
import com.ratnesh.taskmanager.entity.Task;
import com.ratnesh.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        // Business Logic: You could set default status here if not provided
        if (task.getStatus() == null) {
            task.setStatus(Status.OPEN);
        }
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }
}