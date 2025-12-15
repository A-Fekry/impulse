package com.spring.system.task_managment_system.service.auth;

import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.mapper.PersonMapper;
import com.spring.system.task_managment_system.models.Roles;
import com.spring.system.task_managment_system.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private PersonRepo personRepo;


    @Override
    public PersonDto getClientByEmail(String email) {
        return PersonMapper.INSTANCE.toDto(personRepo.findByEmail(email));
    }


    @Override
    public PersonDto saveClient(PersonDto client) {
        return PersonMapper.INSTANCE.toDto(personRepo.save(PersonMapper.INSTANCE.toEntity(client)));
    }

    @Override
    public List<Roles> getRoles(String email) {
        return personRepo.findByEmail(email).getRoles();
    }
}
