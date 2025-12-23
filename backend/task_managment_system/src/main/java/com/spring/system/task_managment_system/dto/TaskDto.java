package com.spring.system.task_managment_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDto {

    private Integer id;
    private String name;
    private String description;
    private LocalDate day;
    private String priority;
    private boolean done;
    private LocalTime actualendTime;
    private LocalTime actualStartTime;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer points;
    private String type;

    List<SubTaskDto> subTasks = new ArrayList<>();
}
