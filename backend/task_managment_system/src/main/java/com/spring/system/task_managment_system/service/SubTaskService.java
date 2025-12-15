package com.spring.system.task_managment_system.service;

import com.spring.system.task_managment_system.dto.SubTaskDto;

public interface SubTaskService {

    SubTaskDto updateSubTask(SubTaskDto subTaskDto) throws RuntimeException;
    void deleteSubTask(SubTaskDto subTaskDto) throws RuntimeException;
}
