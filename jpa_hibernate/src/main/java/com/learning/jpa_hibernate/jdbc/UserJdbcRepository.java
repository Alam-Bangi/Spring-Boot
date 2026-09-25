package com.learning.jpa_hibernate.jdbc;

import com.learning.jpa_hibernate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                insert into users (id , name, email)
                values(?, ?, ?);
            """;
    private static String DELETE_QUERY =
            """
                delete from users
                where id = ?;
            """;
    private static String SELECT_QUERY =
            """
                select * from users
                where id = ?;
            """;

    public void insert(User user) {
        springJdbcTemplate.update(INSERT_QUERY,
                user.getId(), user.getName());
    }
    public void deleteById(long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public User findById(long id) {
        return springJdbcTemplate.queryForObject
                (SELECT_QUERY, new BeanPropertyRowMapper<>(User.class), id);
    }

}
