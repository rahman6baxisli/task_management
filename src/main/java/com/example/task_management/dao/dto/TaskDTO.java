package com.example.task_management.dao.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class TaskDTO {
    private String title;
    private String description;
    private LocalDate deadline;
    private Long userId;
}
