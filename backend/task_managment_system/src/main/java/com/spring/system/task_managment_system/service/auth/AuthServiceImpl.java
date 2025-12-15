package com.spring.system.task_managment_system.service.auth;


import com.spring.system.task_managment_system.config.JwtTokenHandler;
import com.spring.system.task_managment_system.dto.LoginDto;
import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.dto.TokenDto;
import com.spring.system.task_managment_system.mapper.PersonMapper;
import com.spring.system.task_managment_system.models.Person;
import com.spring.system.task_managment_system.models.Roles;
import com.spring.system.task_managment_system.repo.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private ClientService clientService;

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private JwtTokenHandler jwtTokenHandler;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public TokenDto login(LoginDto personDto) throws RuntimeException {
        PersonDto client = clientService.getClientByEmail(personDto.getEmail());
        if (client == null) {
            throw new RuntimeException("username.invalid");
        }

        if(!passwordEncoder.matches(personDto.getPassword(), client.getPassword())) {
            throw new RuntimeException("password.wrong");
        }
        List<Roles> roles = clientService.getRoles(client.getEmail());
        List<String> codes = new ArrayList<>();
        for (Roles role : roles) {
            codes.add(role.getCode());
        }
        return new TokenDto(jwtTokenHandler.createToken(client),codes);
    }

    @Override
    public TokenDto createAccount(PersonDto newDto) throws RuntimeException {
        PersonDto client1 = clientService.getClientByEmail(newDto.getEmail());
        if (client1 != null) {

            throw new RuntimeException("email.used");
        }

        String encodedPassword = passwordEncoder.encode(newDto.getPassword());
        Person client = new Person();
        client.setName(newDto.getName());
        client.setPassword(encodedPassword);
        client.setEmail(newDto.getEmail());
        List<Roles> roles = new ArrayList<>();
        Roles role1 = new Roles();
        role1.setCode("ROLE_USER");
        roles.add(role1);
        client.setRoles(roles);
        personRepo.save(client);
        List<String> code = new ArrayList<>();
        code.add(role1.getCode());
        return new TokenDto(jwtTokenHandler.createToken(PersonMapper.INSTANCE.toDto(client)),code);
    }
}
