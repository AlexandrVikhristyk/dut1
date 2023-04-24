package com.example.student.dto.task.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskCreateRequest {
    private String title;
    private String description;
    private LocalDateTime deadline;
}
