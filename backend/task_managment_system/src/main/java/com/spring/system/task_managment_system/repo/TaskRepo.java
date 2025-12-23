package com.spring.system.task_managment_system.repo;

import com.spring.system.task_managment_system.models.Person;
import com.spring.system.task_managment_system.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    List<Task> findTaskByDayAndPerson(LocalDate day, Person person);

    List<Task> findTaskByDay(LocalDate day);
}
