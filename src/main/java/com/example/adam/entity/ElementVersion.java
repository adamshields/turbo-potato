package com.example.adam.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "element_version")
public class ElementVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "element_id")
    private Long elementId;

    @Column(name = "version_number")
    private Integer versionNumber;

    @Column(name = "resource_data", columnDefinition = "json")
    private String resourceData;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // Getters and setters (or @Data from Lombok)
}
