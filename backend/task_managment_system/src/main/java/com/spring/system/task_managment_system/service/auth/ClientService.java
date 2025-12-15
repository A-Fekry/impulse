package com.spring.system.task_managment_system.service.auth;

import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.models.Roles;

import java.util.List;

public interface ClientService {

    //PersonDto getClientByName(String clientName);
    PersonDto getClientByEmail(String email);
    PersonDto saveClient(PersonDto client);
    List<Roles> getRoles(String email);
}
