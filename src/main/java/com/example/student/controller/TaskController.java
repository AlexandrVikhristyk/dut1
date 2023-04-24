package com.example.student.controller;

import com.example.student.dto.task.request.TaskCreateRequest;
import com.example.student.dto.task.response.TaskResponse;
import com.example.student.entity.Task;
import com.example.student.mapper.TaskMapper;
import com.example.student.repository.TaskRepository;
import com.example.student.service.TaskService;
import lombok.AllArgsConstructor;
import org.apache.catalina.loader.ResourceEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("task")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;

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


