package com.ratnesh.taskmanager.service;

import com.ratnesh.taskmanager.dto.TaskRequest;
import com.ratnesh.taskmanager.dto.TaskResponse;
import com.ratnesh.taskmanager.entity.Task;
import com.ratnesh.taskmanager.entity.User;
import com.ratnesh.taskmanager.repository.TaskRepository;
import com.ratnesh.taskmanager.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository,
                       UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskResponse createTask(TaskRequest request) {

        User assignedUser = userRepository.findById(
                request.getAssignedUserId()
        ).orElseThrow(() ->
                new RuntimeException("Assigned user not found")
        );

        Task task = new Task();

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(request.getStatus());
        task.setPriority(request.getPriority());
        task.setAssignedUser(assignedUser);

        Task savedTask = taskRepository.save(task);

        return mapToResponse(savedTask);
    }

    public List<TaskResponse> getAllTasks() {

        List<Task> tasks = taskRepository.findAll();

        return tasks.stream()
                .map(this::mapToResponse)
                .toList();
    }

    public TaskResponse getTaskById(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found")
                );

        return mapToResponse(task);
    }

    private TaskResponse mapToResponse(Task task) {

        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getPriority(),
                task.getAssignedUser().getName(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }

    public TaskResponse updateTask(Long id,
                                   TaskRequest request) {

        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found")
                );

        User assignedUser = userRepository.findById(
                request.getAssignedUserId()
        ).orElseThrow(() ->
                new RuntimeException("Assigned user not found")
        );

        existingTask.setTitle(request.getTitle());
        existingTask.setDescription(request.getDescription());
        existingTask.setStatus(request.getStatus());
        existingTask.setPriority(request.getPriority());
        existingTask.setAssignedUser(assignedUser);

        Task updatedTask = taskRepository.save(existingTask);

        return mapToResponse(updatedTask);
    }

    public void deleteTask(Long id) {

        Task task = taskRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Task not found")
                );

        taskRepository.delete(task);
    }
}