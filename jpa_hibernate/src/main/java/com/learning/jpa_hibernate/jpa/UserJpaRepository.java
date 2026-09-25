package com.learning.jpa_hibernate.jpa;

import com.learning.jpa_hibernate.entity.Course;
import com.learning.jpa_hibernate.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(User user) {
        entityManager.merge(user);
    }

    public User findById(long id) {
        return entityManager.find(User.class, id);
    }

    public void deleteById(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
}
