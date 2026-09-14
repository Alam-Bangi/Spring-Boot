package com.taskify.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class TaskRequest {
    public String name;
    public boolean isCompleted;
}
