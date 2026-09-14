package com.taskify.controller;

import com.taskify.dto.TaskRequest;
import com.taskify.entity.Task;
import com.taskify.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping("/{id}/task")
    public Task createTask(@PathVariable Long id, @RequestBody TaskRequest taskRequest) {
        System.out.println(id + ", " +taskRequest);
        Task task = taskService.addTask(id, taskRequest);
        return task;
    }

    @GetMapping("/task")
    public String getTask() {
        return "index";
    }
}
