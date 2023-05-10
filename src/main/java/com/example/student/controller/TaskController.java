package com.example.student.controller;

import com.example.student.dto.task.request.TaskCreateRequest;
import com.example.student.dto.task.response.TaskResponse;
import com.example.student.mapper.TaskMapperOld;
import com.example.student.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapperOld taskMapper;

    @GetMapping
    public List<TaskResponse> getAll() {
        return taskService.getAll().stream().map(taskMapper::toDto).toList();
    }

    @GetMapping("/{id}")
    public TaskResponse get(@PathVariable Long id) {
        return taskMapper.toDto(taskService.get(id));
    }

    @PostMapping
    public TaskResponse create(@RequestBody TaskCreateRequest taskDto) {
        return taskMapper.toDto(taskService.create(taskMapper.fromDto(taskDto)));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}


