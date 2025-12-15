package com.spring.system.task_managment_system.service.auth;

import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.dto.LoginDto;
import com.spring.system.task_managment_system.dto.TokenDto;

public interface AuthService {


    TokenDto login(LoginDto clientDto) throws RuntimeException;

    TokenDto createAccount(PersonDto newDto) throws RuntimeException;
}
