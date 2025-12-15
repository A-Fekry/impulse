package com.spring.system.task_managment_system.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roles_seq")
    @SequenceGenerator(name = "role_seq", sequenceName = "ROLE_SEQ", allocationSize = 1)
    private Integer id;

    @Column(nullable = false)
    private String code;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "roles")
    private List<Person> people;
}
