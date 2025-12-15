package com.spring.system.task_managment_system.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class SubTask {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subtask_seq")
    @SequenceGenerator(name = "subtask_seq", sequenceName = "SUBTASK_SEQ", allocationSize = 1)
    private Integer id;

    private String name;

    private Integer time;

    @Column(nullable = false)
    private boolean done;


    @ManyToOne(fetch = FetchType.LAZY)
    private Task task;
}
