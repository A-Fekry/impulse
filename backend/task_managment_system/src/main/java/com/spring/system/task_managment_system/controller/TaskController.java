package com.spring.system.task_managment_system.controller;


import com.spring.system.task_managment_system.dto.ResponseSub;
import com.spring.system.task_managment_system.dto.TaskDto;
import com.spring.system.task_managment_system.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/task")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    ResponseEntity<TaskDto> addTask(@RequestBody @Validated TaskDto taskDto) {
        return ResponseEntity.ok(taskService.addTask(taskDto));
    }

    @PostMapping("/add-big-task")
    ResponseEntity<TaskDto> addBigTask(@RequestBody @Validated TaskDto taskDto) {
        return ResponseEntity.ok(taskService.addBigTask(taskDto));
    }


    @PostMapping("/update")
    ResponseEntity<TaskDto> updateTask(@RequestBody @Validated TaskDto taskDto) {
        return ResponseEntity.ok(taskService.updateTask(taskDto));
    }

    @DeleteMapping("/delete")
    void deleteTask(@RequestBody @Validated TaskDto taskDto) {
        taskService.deleteTaskById(taskDto.getId());
    }

    @GetMapping("/get-task/date/{date}")
    ResponseEntity<List<TaskDto>> getTodayTasks(@PathVariable("date") LocalDate day) {
        return ResponseEntity.ok(taskService.getTaskByDate(day));
    }

    @GetMapping("/points")
    ResponseEntity<Integer> points() {
        return ResponseEntity.ok(taskService.countPoints());
    }
}
