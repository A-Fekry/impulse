package com.spring.system.task_managment_system.service.impl;

import com.spring.system.task_managment_system.dto.SubTaskDto;
import com.spring.system.task_managment_system.mapper.SubTaaskMapper;
import com.spring.system.task_managment_system.repo.SubTaskRepo;
import com.spring.system.task_managment_system.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubTaskServiceImpl implements SubTaskService {
    @Autowired
    private SubTaskRepo subTaskRepo;
    @Override
    public SubTaskDto updateSubTask(SubTaskDto subTaskDto) throws RuntimeException {
        if(subTaskDto.getId() == null){
            throw new RuntimeException("invalid.sub.id");
        }
        SubTaskDto subTaskDto1 = SubTaaskMapper.INSTANCE.toDto(subTaskRepo.findById(subTaskDto.getId()).orElse(null));
        if(subTaskDto1 == null){
            throw new RuntimeException("invalid.sub.id");
        }
        return SubTaaskMapper.INSTANCE.toDto(subTaskRepo.save(SubTaaskMapper.INSTANCE.toEntity(subTaskDto1)));
    }

    @Override
    public void deleteSubTask(SubTaskDto subTaskDto) throws RuntimeException {
        subTaskRepo.deleteById(subTaskDto.getId());
    }
}
