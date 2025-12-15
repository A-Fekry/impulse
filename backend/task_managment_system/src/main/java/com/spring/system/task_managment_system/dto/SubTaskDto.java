package com.spring.system.task_managment_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SubTaskDto {

    private Integer id;
    private String name;
    private Integer time;
    private boolean done;
}
