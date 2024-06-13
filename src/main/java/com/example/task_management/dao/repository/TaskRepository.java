package com.example.task_management.dao.repository;


import com.example.task_management.dao.entity.Task;
import com.example.task_management.dao.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
    List<Task> findByStatus(Status status);
    List<Task> findByDeadline(LocalDate deadline);
}
