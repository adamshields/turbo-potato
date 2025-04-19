package com.example.adam.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "search_index")
@Data
public class SearchIndex {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long referenceId;
    private String referenceType;
    private String label;
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String rawContent;

    private LocalDateTime createdAt;
}
