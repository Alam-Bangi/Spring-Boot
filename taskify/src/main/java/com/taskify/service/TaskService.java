package com.taskify.service;

import com.taskify.dto.TaskRequest;
import com.taskify.entity.Task;
import com.taskify.entity.User;
import com.taskify.repository.TaskRepository;
import com.taskify.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public Task addTask(Long userId, TaskRequest taskRequest) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        Task byName = taskRepository.findByName(taskRequest.name);
        if(Objects.isNull(byName)) {
            Task task = Task.builder()
                    .name(taskRequest.name)
                    .completed(taskRequest.completed)
                    .user(user.get())
                    .build();
            byName = taskRepository.save(task);
        }
        return byName;
    }

    public Task updateTask(Long id, TaskRequest taskRequest) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        task.setName(taskRequest.getName());
        task.setCompleted(taskRequest.isCompleted());

        return taskRepository.save(task);
    }

    public List<Task> getTaskForUser(Long id) {
        return taskRepository.findByUserId(id);
    }

    public void deleteTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        taskRepository.delete(task);
    }
}
