package com.spring.system.task_managment_system.config;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface DtoConfig {
}
