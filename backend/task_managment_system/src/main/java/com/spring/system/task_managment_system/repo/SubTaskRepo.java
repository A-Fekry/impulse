package com.spring.system.task_managment_system.repo;

import com.spring.system.task_managment_system.models.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTaskRepo extends JpaRepository<SubTask, Integer> {
}
