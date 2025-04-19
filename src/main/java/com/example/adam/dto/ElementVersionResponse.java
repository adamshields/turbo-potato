package com.example.adam.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ElementVersionResponse {
    private Long id;
    private Long elementId;
    private Integer versionNumber;
    private String resourceData;
    private LocalDateTime createdAt;
}
