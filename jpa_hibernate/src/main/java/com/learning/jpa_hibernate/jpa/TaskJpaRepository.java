package com.learning.jpa_hibernate.jpa;

import com.learning.jpa_hibernate.entity.Task;
import com.learning.jpa_hibernate.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class TaskJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Task task) {
        entityManager.merge(task);
    }

    public Task findById(long id) {
        return entityManager.find(Task.class, id);
    }

    public void deleteById(long id) {
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
    }

    public List<Task> findByUserId (long id) {
        User user = entityManager.find(User.class, id);
        return user.getTaskList();
    }
}
