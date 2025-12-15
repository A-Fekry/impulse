package com.spring.system.task_managment_system.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private Integer id;

    private String name;
    private String password;
    private String email;
}

