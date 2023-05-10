package com.example.student.mapper;

import com.example.student.dto.task.request.TaskCreateRequest;
import com.example.student.dto.task.response.TaskResponse;
import com.example.student.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.time.LocalDate;

@Mapper(imports = LocalDate.class)
public interface TaskMapper {

    @Mappings({
            @Mapping(target = "taskTitle", source = "title"),
            @Mapping(target = "userId", source = "entity.user.id"),
    })
    TaskResponse toDto(Task entity);

    Task fromDto(TaskCreateRequest dto);
}
