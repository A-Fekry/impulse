package com.spring.system.task_managment_system.repo;

import com.spring.system.task_managment_system.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends JpaRepository<Person, Integer> {
    Person findByEmail(String email);
}
