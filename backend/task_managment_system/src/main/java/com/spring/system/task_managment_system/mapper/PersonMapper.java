package com.spring.system.task_managment_system.mapper;

import com.spring.system.task_managment_system.config.DtoConfig;
import com.spring.system.task_managment_system.dto.PersonDto;
import com.spring.system.task_managment_system.models.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", config = DtoConfig.class)
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    Person toEntity(PersonDto personDto);
    PersonDto toDto(Person person);
    List<PersonDto> toDto(List<Person> personList);
    List<Person> toEntity(List<PersonDto> personDtoList);
}
