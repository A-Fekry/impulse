package com.spring.system.task_managment_system.mapper;


import com.spring.system.task_managment_system.config.DtoConfig;
import com.spring.system.task_managment_system.dto.SubTaskDto;
import com.spring.system.task_managment_system.models.SubTask;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", config = DtoConfig.class)
public interface SubTaaskMapper {

    SubTaaskMapper INSTANCE = Mappers.getMapper(SubTaaskMapper.class);

    SubTask toEntity(SubTaskDto subTaskDto);
    SubTaskDto toDto(SubTask subTask);
    List<SubTaskDto> toDto(List<SubTask> subTasks);
    List<SubTask> toEntity(List<SubTaskDto> subTaskDtos);
}
