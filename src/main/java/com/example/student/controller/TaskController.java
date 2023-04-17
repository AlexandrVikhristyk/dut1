package com.example.student.controller;

import com.example.student.entity.Task;
import com.example.student.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("hello")
//http://localhost:8080/createTask
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("getAllTask")
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @GetMapping("getOneTask/{taskNumber}")
    public Task getTask(@PathVariable Long taskNumber) {
        return taskRepository.findById(taskNumber).get();
    }

    @PostMapping("createTask")
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @DeleteMapping("deleteTask/{taskNumber}")
    public String deleteTask(@PathVariable Long taskNumber) {
        taskRepository.deleteById(taskNumber);
        return "Task by:" + taskNumber + " has been removed";
    }
}


