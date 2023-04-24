package com.example.student.mapper;

import com.example.student.dto.task.request.TaskCreateRequest;
import com.example.student.dto.task.response.TaskResponse;
import com.example.student.entity.Task;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TaskMapper {
    public Task fromDto(TaskCreateRequest dto) {
        if (Objects.isNull(dto)) {
            return null;
        }

        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setDeadline(dto.getDeadline());

        return task;
    }

    public TaskResponse toDto(Task entity) {
        if (Objects.isNull(entity)) {
            return null;
        }

        TaskResponse dto = new TaskResponse();
        dto.setId(entity.getId());

        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setDeadline(entity.getDeadline());

        if (Objects.nonNull(entity.getUser())) {
            dto.setUserId(entity.getUser().getId());
        }

        return dto;
    }
}
