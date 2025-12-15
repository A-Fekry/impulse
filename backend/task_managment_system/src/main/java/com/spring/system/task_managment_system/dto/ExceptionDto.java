package com.spring.system.task_managment_system.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionDto {
    private int status;
    private String messageAr;
    private String messageEn;
    private ExceptionData data;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ExceptionData {
        private LocalDateTime timestamp;
        private String path;
    }
}

