package com.spring.system.task_managment_system.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq", sequenceName = "TASK_SEQ", allocationSize = 1)
    private Integer id;

   private String name;

   @Size(min = 1, max = 1000)
   private String description;

   @Column(nullable = false)
   private LocalDate day;

   private String priority;

   @Column(nullable = false)
   private boolean done;

   private LocalTime actualStartTime;

   private LocalTime actualendTime;


   @Column(nullable = true)
   private LocalTime startTime;


    @Column(nullable = true)
    private LocalTime endTime;

    @Min(0)
    @Max(100)
    private Integer points;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubTask> subTasks;
}
