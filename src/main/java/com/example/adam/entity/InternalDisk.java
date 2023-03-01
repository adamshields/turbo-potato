package com.example.adam.entity;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "internal_disk")
public class InternalDisk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
}