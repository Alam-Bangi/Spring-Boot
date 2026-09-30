package com.taskify.repository;

import com.taskify.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByName(String name);
    List<Task> findByUserId(Long id);
}
