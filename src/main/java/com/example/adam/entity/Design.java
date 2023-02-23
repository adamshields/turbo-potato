package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "designs")
public class Design {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String version;

    // constructors, getters, and setters
}
