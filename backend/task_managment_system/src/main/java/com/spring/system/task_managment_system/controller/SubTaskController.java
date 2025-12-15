package com.spring.system.task_managment_system.controller;


import com.spring.system.task_managment_system.dto.SubTaskDto;
import com.spring.system.task_managment_system.service.SubTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sub-task")
@CrossOrigin(origins = "http://localhost:5173")
public class SubTaskController {

    @Autowired
    private SubTaskService subTaskService;

    @PostMapping("/update")
    ResponseEntity<SubTaskDto> update(@RequestBody @Validated SubTaskDto subTaskDto) {
        return ResponseEntity.ok(subTaskService.updateSubTask(subTaskDto));
    }

    @DeleteMapping("/delete")
    void delete(@RequestBody @Validated SubTaskDto subTaskDto) {
        subTaskService.deleteSubTask(subTaskDto);
    }
}
