package com.taskify.controller;

import com.taskify.dto.TaskRequest;
import com.taskify.entity.Task;
import com.taskify.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping("/{user_id}/task")
    public Task createTask(@PathVariable Long user_id, @RequestBody TaskRequest taskRequest) {
        System.out.println(user_id + ", " +taskRequest);
        return taskService.addTask(user_id, taskRequest);
    }

    @PutMapping("/{user_id}/task/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        return taskService.updateTask(id, taskRequest);
    }

    @GetMapping("/{id}/task")
    public List<Task> getTaskForUser(@PathVariable Long id) {
        return taskService.getTaskForUser(id);
    }

    @DeleteMapping("/{user_id}/task/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
