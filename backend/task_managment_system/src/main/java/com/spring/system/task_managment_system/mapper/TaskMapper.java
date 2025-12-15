package com.spring.system.task_managment_system.mapper;

import com.spring.system.task_managment_system.config.DtoConfig;
import com.spring.system.task_managment_system.dto.TaskDto;
import com.spring.system.task_managment_system.models.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring", config = DtoConfig.class)
public interface TaskMapper {

    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskDto toDto(Task task);
    Task toEntity(TaskDto taskDto);
    List<TaskDto> toDto(List<Task> tasks);
    List<Task> toEntity(List<TaskDto> taskDtos);
}
