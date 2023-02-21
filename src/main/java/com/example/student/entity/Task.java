package com.example.student.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime deadline;

    private LocalDate createdDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
}
