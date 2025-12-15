package com.spring.system.task_managment_system.service;

import com.spring.system.task_managment_system.dto.ResponseSub;
import com.spring.system.task_managment_system.dto.TaskDto;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {

    TaskDto addTask(TaskDto taskDto) throws RuntimeException;
    TaskDto updateTask(TaskDto taskDto) throws RuntimeException;
    TaskDto getTaskById(int id);
    List<TaskDto> getTaskByDate(LocalDate date) throws RuntimeException;
    void deleteTaskById(int id) throws RuntimeException;
    ResponseSub addBigTask(ResponseSub responseSub) throws RuntimeException;
    Integer countPoints();
}
