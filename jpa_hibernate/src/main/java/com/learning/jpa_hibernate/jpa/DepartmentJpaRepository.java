package com.learning.jpa_hibernate.jpa;

import com.learning.jpa_hibernate.entity.Department;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
@Transactional
public class DepartmentJpaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Department department ) {
        entityManager.merge(department);
    }

//    public Department findById(long id) {
//        return Objects.nonNull(entityManager.find(Department.class, id)) ? entityManager.find(Department.class, id) : ;
//    }

    public void deleteById(long id) {
        Department department = entityManager.find(Department.class, id);
        entityManager.remove(department);
    }
}
