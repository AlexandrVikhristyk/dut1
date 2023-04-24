package com.example.student.service;

import com.example.student.common.exceprion.BadRequestException;
import com.example.student.entity.Task;
import com.example.student.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {
    private TaskRepository taskRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task get(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new BadRequestException("Task not found by id " + id));
    }

    public Task create(Task task) {
        task.setCreatedDate(LocalDate.now());
//        task.setUser(); // set currently logged in user
        return taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.delete(get(id));
    }
}
