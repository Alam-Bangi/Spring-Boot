package com.learning.jpa_hibernate.jdbc;

import com.learning.jpa_hibernate.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into department (id , name)
                values(?, ?);
            """;
    private static String DELETE_QUERY =
            """
                delete from department
                where id = ?;
            """;
    private static String SELECT_QUERY =
            """
                select * from department
                where id = ?;
            """;

    public void insert(Department department) {
        springJdbcTemplate.update(INSERT_QUERY,
                department.getId(), department.getName());
    }
    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Department findById(long id) {
        return springJdbcTemplate.queryForObject
                (SELECT_QUERY, new BeanPropertyRowMapper<>(Department.class), id);
    }
}
