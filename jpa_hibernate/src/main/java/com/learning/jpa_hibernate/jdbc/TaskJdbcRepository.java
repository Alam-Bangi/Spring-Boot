package com.learning.jpa_hibernate.jdbc;

import com.learning.jpa_hibernate.entity.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TaskJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into task (id , name, description, isCompleted)
                values(?, ?, ?, ?);
            """;
    private static String DELETE_QUERY =
            """
                delete from task
                where id = ?;
            """;
    private static String SELECT_QUERY =
            """
                select * from task
                where id = ?;
            """;

    public void insert(Task task) {
        springJdbcTemplate.update(INSERT_QUERY,
                task.getId(), task.getName(), task.getDescription(), task.isCompleted());
    }
    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Task findById(long id) {
        return springJdbcTemplate.queryForObject
                (SELECT_QUERY, new BeanPropertyRowMapper<>(Task.class), id);
    }
}
