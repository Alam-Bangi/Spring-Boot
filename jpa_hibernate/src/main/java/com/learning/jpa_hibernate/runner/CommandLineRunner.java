package com.learning.jpa_hibernate.runner;

import com.learning.jpa_hibernate.entity.Course;
import com.learning.jpa_hibernate.entity.Department;
import com.learning.jpa_hibernate.entity.Task;
import com.learning.jpa_hibernate.entity.User;
import com.learning.jpa_hibernate.jdbc.UserJdbcRepository;
import com.learning.jpa_hibernate.jpa.CourseJpaRepository;
import com.learning.jpa_hibernate.jpa.DepartmentJpaRepository;
import com.learning.jpa_hibernate.jpa.TaskJpaRepository;
import com.learning.jpa_hibernate.jpa.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommandLineRunner implements org.springframework.boot.CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository jdbcRepository;

    @Autowired
    private CourseJpaRepository courseJpaRepository;

    @Autowired
    private DepartmentJpaRepository departmentJpaRepository;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private TaskJpaRepository taskJpaRepository;

    @Override
    public void run(String... args) throws Exception {
//        jdbcRepository.insert(new Course(1, "Learn JAVA", "Oracle"));
//        jdbcRepository.insert(new Course(2, "Learn Cloud", "Google"));
//        jdbcRepository.insert(new Course(3, "Learn AWS", "Amazon"));
//
//        jdbcRepository.deleteById(2);
//
//        System.out.println(jdbcRepository.findById(1));
//        System.out.println(jdbcRepository.findById(3));



        courseJpaRepository.insert(new Course(1, "Learning Java", "Oracle"));
        courseJpaRepository.insert(new Course(2, "Learning DevOps", "Cloud"));
        courseJpaRepository.insert(new Course(3, "Learning AWS", "Amazon"));

        courseJpaRepository.deleteById(3);

//        System.out.println(courseJpaRepository.findById(2));
//        System.out.println(courseJpaRepository.findById(1));

        departmentJpaRepository.insert(new Department(1, "Computer"));
        departmentJpaRepository.insert(new Department(2, "IT"));
        departmentJpaRepository.insert(new Department(3, "Electrical"));

        departmentJpaRepository.deleteById(3);

//        System.out.println(departmentJpaRepository.findById(2));
//        System.out.println(departmentJpaRepository.findById(5));

//        List<Task> tasks = new ArrayList<>();
//        tasks.add(new Task(1));

        userJpaRepository.insert(new User(101, "ALAM", "abc12@gmail.com", null));
        userJpaRepository.insert(new User(201, "AMAN", "cd34@gmail.com", null));

        User user = userJpaRepository.findById(101);
        taskJpaRepository.insert(new Task(user, 1, "Learn", "Spring", false));
        taskJpaRepository.insert(new Task(user, 2, "Learn", "Boot", true));

        User user1 = userJpaRepository.findById(201);
        taskJpaRepository.insert(new Task(user1, 1, "Learn", "Spring", false));

        System.out.println(userJpaRepository.findById(201));
        System.out.println(taskJpaRepository.findById(1));

        System.out.println(taskJpaRepository.findByUserId(201));
    }
}
