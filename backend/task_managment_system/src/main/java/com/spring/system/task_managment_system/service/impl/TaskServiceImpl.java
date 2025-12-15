package com.spring.system.task_managment_system.service.impl;

import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.dto.ResponseSub;
import com.spring.system.task_managment_system.dto.TaskDto;
import com.spring.system.task_managment_system.mapper.PersonMapper;
import com.spring.system.task_managment_system.mapper.SubTaaskMapper;
import com.spring.system.task_managment_system.mapper.TaskMapper;
import com.spring.system.task_managment_system.models.SubTask;
import com.spring.system.task_managment_system.models.Task;
import com.spring.system.task_managment_system.repo.SubTaskRepo;
import com.spring.system.task_managment_system.repo.TaskRepo;
import com.spring.system.task_managment_system.service.TaskService;
import com.spring.system.task_managment_system.service.auth.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private ClientService clientService;

    @Autowired
    private SubTaskRepo subTaskRepo;
    @Override
    public TaskDto addTask(TaskDto taskDto) throws RuntimeException {
        if(taskDto.getId() != null) {
            throw new RuntimeException("invalid.id");
        }
        LocalDate date = LocalDate.now();
        LocalDate day = taskDto.getDay();
        if (day.isBefore(date) || day == null) {
            throw new RuntimeException("day.must.be.before.date");
        }
        if(taskDto.getEndTime().isBefore(taskDto.getStartTime())) {
            throw new RuntimeException("startTime.must.be.before.endTime");
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PersonDto client = (PersonDto) clientService.getClientByEmail((String) auth.getName());
        taskDto.setDone(false);
        Task task = new Task();
        task = TaskMapper.INSTANCE.toEntity(taskDto);
        task.setPerson(PersonMapper.INSTANCE.toEntity(client));
        return TaskMapper.INSTANCE.toDto(taskRepo.save(task));
    }

    @Override
    public TaskDto updateTask(TaskDto taskDto)  throws RuntimeException{
        if(taskDto.getId() == null) {
            throw new RuntimeException("invalid.id.1");
        }
        TaskDto taskTest = getTaskById(taskDto.getId());
        if(taskTest == null) {
            throw new RuntimeException("invalid.id.2");
        }
        LocalDate date = LocalDate.now();
        LocalDate day = taskDto.getDay();
        if (day.isBefore(date) || day == null) {
            throw new RuntimeException("day.must.be.before.date");
        }
        if(taskDto.getEndTime().isBefore(taskDto.getStartTime())) {
            throw new RuntimeException("startTime.must.be.before.endTime");
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PersonDto client = (PersonDto) clientService.getClientByEmail((String) auth.getName());
        taskDto.setDone(false);
        Task task = new Task();
        task = TaskMapper.INSTANCE.toEntity(taskDto);
        task.setPerson(PersonMapper.INSTANCE.toEntity(client));
        return TaskMapper.INSTANCE.toDto(taskRepo.save(task));
    }

    @Override
    public TaskDto getTaskById(int id) {
        return TaskMapper.INSTANCE.toDto(taskRepo.findById(id).orElse(null));
    }

    @Override
    public List<TaskDto> getTaskByDate(LocalDate date)  throws RuntimeException{
        return TaskMapper.INSTANCE.toDto(taskRepo.findTaskByDay(date));
    }

    @Override
    public void deleteTaskById(int id) throws RuntimeException {
        TaskDto taskTest = getTaskById(id);
        if(taskTest == null) {
            throw new RuntimeException("invalid.id.2");
        }
        taskRepo.deleteById(id);
    }

    @Override
    public ResponseSub addBigTask(ResponseSub responseSub) throws RuntimeException {
        TaskDto taskDto = responseSub.getTask();
        if(taskDto.getId() != null) {
            throw new RuntimeException("invalid.id");
        }
        LocalDate date = LocalDate.now();
        LocalDate day = taskDto.getDay();
        if (day.isBefore(date) || day == null) {
            throw new RuntimeException("day.must.be.before.date");
        }
        if(taskDto.getEndTime().isBefore(taskDto.getStartTime())) {
            throw new RuntimeException("startTime.must.be.before.endTime");
        }
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        PersonDto client = (PersonDto) clientService.getClientByEmail((String) auth.getName());
        taskDto.setDone(false);
        Task task = new Task();
        task = TaskMapper.INSTANCE.toEntity(taskDto);
        task.setPerson(PersonMapper.INSTANCE.toEntity(client));
        Task result = taskRepo.save(task);
        for (int i = 0; i < responseSub.getSubTasks().size(); i++) {
            SubTask subTask = new SubTask();
            subTask = SubTaaskMapper.INSTANCE.toEntity(responseSub.getSubTasks().get(i));
            subTask.setTask(task);
            result.getSubTasks().add(subTask);
        }
        ResponseSub responseSubRes = new ResponseSub();
        responseSubRes.setSubTasks(SubTaaskMapper.INSTANCE.toDto(result.getSubTasks()));
        responseSubRes.setTask(TaskMapper.INSTANCE.toDto(result));
        return responseSubRes;
    }

    @Override
    public Integer countPoints() {
        List<TaskDto> taskDtoList = getTaskByDate(LocalDate.now());
        Integer count = 0;
        for (TaskDto taskDto : taskDtoList) {
            if(taskDto.isDone()){
                count += taskDto.getPoints();
            }
        }
        return count;
    }
}
