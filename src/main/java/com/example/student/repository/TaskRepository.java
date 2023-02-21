package com.example.student.repository;

import com.example.student.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query("SELECT t FROM Task t where t.description = :description")
    List<Task> findTasksByDescription(String description);

    @Query(nativeQuery = true, value = "SELECT * FROM Task WHERE Task.title = :title")
    List<Task> findTasksByTitle(String title);
}
