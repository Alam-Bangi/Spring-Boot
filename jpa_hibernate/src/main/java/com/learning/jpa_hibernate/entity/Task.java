package com.learning.jpa_hibernate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "task")
public class Task {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    @Id
    private long id;
    private String name;
    private String description;
    boolean isCompleted;

}
