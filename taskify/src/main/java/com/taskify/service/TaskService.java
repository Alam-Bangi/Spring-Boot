package com.taskify.service;

import com.taskify.dto.TaskRequest;
import com.taskify.entity.Task;
import com.taskify.entity.User;
import com.taskify.repository.TaskRepository;
import com.taskify.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public Task addTask(Long userId, TaskRequest taskRequest) {
        Optional<User> user = userRepository.findById(userId);
        Task byName = taskRepository.findByName(taskRequest.name);
        if(Objects.isNull(byName)) {
            Task task = Task.builder()
                    .name(taskRequest.name)
                    .completed(taskRequest.isCompleted)
                    .user(user.get())
                    .build();
            byName = taskRepository.save(task);
        }
        return byName;
    }
}
