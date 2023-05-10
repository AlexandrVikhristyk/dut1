package com.example.student.dto.task.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TaskResponse {
    private Long id;
    private String taskTitle;
    private String description;
    private LocalDateTime deadline;
    private LocalDate createdDate;
    private Long userId;
}
